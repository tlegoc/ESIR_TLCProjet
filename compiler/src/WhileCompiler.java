import SymbolTable.SymbolTable;
import ThreeAddr.Program;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WhileCompiler {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private final String filename;
    private Program program;
    private SymbolTable symbolTable;
    private String cpp_output;

    public WhileCompiler(String file) {
        filename = file;
    }

    /***
     * Compile the selected .while file
     * @param compileToExe If set to true, an exe will be created with the name filename.exe
     * @param runOptimizations If set to true, the compiler will try to optimize the three address code
     * @return true if the program compiled, false otherwise
     */
    public boolean compile(String mainFunc, boolean compileToExe, boolean runOptimizations) {
        if (!isGccInstalled()) {
            System.out.println("Error: GCC is not installed.");
            return false;
        }

        Object ast;

        try {
            CharStream input = new ANTLRFileStream(filename);

            whileLexer lex = new whileLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            whileParser pars = new whileParser(tokens);

            whileParser.start_rule_return src = pars.start_rule();

            ast = src.getTree();
        } catch (IOException e) {
            System.out.println("Error: could not open source file.");
            return false;
        } catch (RecognitionException e) {
            System.out.println("Error: unknown ANTLR runtime exception.");
            System.out.println(e.getLocalizedMessage());
            return false;
        }

        // Creating intermediate code
        VisitorTA visitorTA = new VisitorTA();
        visitorTA.visit(ast);
        program = visitorTA.getProgram();

        System.out.println(program.getProgramString(true));

        // Creating symbol table
        VisitorTS visitorTS = new VisitorTS();
        visitorTS.visit(ast);
        symbolTable = visitorTS.getST();

            symbolTable.printSymbolTable();

        // On effectue la validation apres generation du code 3 adresses car simplifie
        // La verification.
        // En toute logique il serait preferable de le faire avant
        WhileValidator wv = new WhileValidator(program, symbolTable, mainFunc);

        // Validation
        if (!wv.validate()) {
            System.out.println("Error, could not validate program");
            return false;
        }

        // TODO optimisation
        if (runOptimizations) program.optimize();

        if (!compileToExe) return true;

        CPPConverter cppConverter = new CPPConverter(getProgram(), symbolTable, mainFunc);
        cpp_output = cppConverter.convert();

        Path filepath = Paths.get(filename);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath.getFileName() + ".cpp"));
            writer.write(cpp_output);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: could not write .cpp file.");
            return false;
        }

        // Appel de GCC
        List<String> params = new ArrayList<>();
        params.add(filepath.getFileName() + ".cpp");
        params.add("-Bstatic");
        params.add("-L./");
        params.add("-lwhile");
        callGCC(params, filename + ".exe");

        // delete temporary
//        File toDel = new File(filepath.getFileName() + ".cpp");
//        if (toDel.exists() && !toDel.isDirectory())
//            toDel.delete();

        return true;
    }

    public void callGCC(List<String> params, String output) {
        System.out.println("Calling g++...");
        List<String> command = new ArrayList<>();
        if (System.getProperty("os.name").contains("Windows")) {
            command.add("cmd");
            command.add("/c");
            command.add("g++");
        } else command.add("g++");

        command.addAll(params);

        if (!output.isEmpty()) {
            command.add("-o");
            command.add(output);
        }

        ProcessBuilder pb = new ProcessBuilder();
        pb.command(command);
        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error: unknown IO error - " + e.getLocalizedMessage() + ANSI_RESET);
        }
    }

    public void printProgram() {
        if (program == null) System.out.println("Programme pas encore compilé. Veuillez appeller .compile()");
        System.out.println(program.getProgramString(true));
    }

    public void printSymbolTable() {
        symbolTable.printSymbolTable();
    }

    public Program getProgram() {
        return program;
    }

    public Boolean isGccInstalled() {
        try {
            List<String> command = new ArrayList<>();
            if (System.getProperty("os.name").contains("Windows")) {
                command.add("cmd");
                command.add("/c");
                command.add("g++");
            } else command.add("g++");

            command.add("--h");

            ProcessBuilder pb = new ProcessBuilder();
            pb.command(command);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            // Necessaire pour une raison inconnue
            String line;

            while ((line = reader.readLine()) != null) {

            }
            if (p.exitValue() != 0) return false;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    // Sauvegarde du code " adresse
    // TODO : Deplacer dans Program.java
    public void saveProgram(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".w3a"));
        writer.write(getProgram().getProgramString().toLowerCase());
        writer.close();
    }
}
