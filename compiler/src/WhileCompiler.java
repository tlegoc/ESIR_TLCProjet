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
import java.util.List;
import java.util.Scanner;


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

        String compilerPath = "";
        if (System.getProperty("os.name").contains("Windows")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your visual studio instalation folder:");
            compilerPath = sc.nextLine();
        }

        Path cp = Paths.get(compilerPath);

        // Appel de GCC
        List<String> commands = new ArrayList<>();
        System.out.println("Calling C++ compiler...");
        if (System.getProperty("os.name").contains("Windows")) {
            commands.add("cmd");
            commands.add("/c");
            Path vcvarsallpath = Paths.get(cp.toString(), "VC", "Auxiliary", "Build", "vcvarsall.bat");
            commands.add(vcvarsallpath.toString());
            commands.add("x64");
            commands.add("&&");

            commands.add("cl");

            // I hate msvc using command line
            commands.add("/MT");

            commands.add(filepath.getFileName() + ".cpp");

            commands.add("/I");
            commands.add("./");

            commands.add("/o");
            commands.add(filepath.toString() + ".exe");

            commands.add("/link");
            commands.add("while.lib");

        } else {
            commands.add("g++");

            commands.add(filepath.getFileName() + ".cpp");

            commands.add("-o");
            commands.add(filepath.toString() + ".exe");

            commands.add("-Bstatic");
            commands.add("-L./");
            commands.add("-lwhile");
        }


        ProcessBuilder pb = new ProcessBuilder(commands);
        try {
            System.out.println("Running: " + commands);
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("Compiler finished with exit code " + p.waitFor());
        } catch (IOException | InterruptedException e) {
            System.out.println(ANSI_RED + "Error: unknown IO error - " + e.getLocalizedMessage() + ANSI_RESET);
        }

        // delete temporary
//        File toDel = new File(filepath.getFileName() + ".cpp");
//        if (toDel.exists() && !toDel.isDirectory())
//            toDel.delete();

        return true;
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

    // Sauvegarde du code " adresse
    // TODO : Deplacer dans Program.java
    public void saveProgram(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".w3a"));
        writer.write(getProgram().getProgramString().toLowerCase());
        writer.close();
    }
}
