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
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private String filename;

    private VisitorTA visitorTA;
    private VisitorTS visitorTS;

    private Program program;
    private SymbolTable symbolTable;

    private String cpp_output;

    public WhileCompiler(String file) {
        filename = file;
    }

    /***
     * Compile the select .while file
     * @param compileToExe If set to true, an exe will be created with the name filename.exe
     * @param runOptimizations If set to true, the compiler will try to optimize the three address code
     * @return true if the program compiled, false otherwise
     * @throws IOException
     */
    public boolean compile(String mainFunc, boolean compileToExe, boolean runOptimizations) throws IOException {
        if (!isGccInstalled()) {
            System.out.println("Error: GCC is not installed.");
            return false;
        }

        CharStream input = new ANTLRFileStream(filename);

        whileLexer lex = new whileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        whileParser pars = new whileParser(tokens);

        try {
            whileParser.start_rule_return src = pars.start_rule();

            Object ast = src.getTree();

            // Creating intermediate code
            visitorTA = new VisitorTA();
            visitorTA.visit(ast);
            program = visitorTA.getProgram();

//            System.out.println(program.getProgramString(true));

            // Creating symbol table
            visitorTS = new VisitorTS();
            visitorTS.visit(ast);
            symbolTable = visitorTS.getST();

//            symbolTable.printSymbolTable();

            WhileValidator wv = new WhileValidator(program, symbolTable);

            // Validation
            if (!wv.validate()) {
                System.out.println("Error, could not validate program");
                return false;
            }

            if (runOptimizations) program.optimize();

            // Convert to cpp
            if (!compileToExe) {
                return true;
            }

            convert3AtoCPP(mainFunc);

            Path filepath = Paths.get(filename);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath.getFileName() + ".cpp"));
            writer.write(cpp_output);
            writer.close();

            // COMPILATION EN C PUIS APPEL DE GCC
            List<String> params = new ArrayList<>();
            params.add(filepath.getFileName() + ".cpp");
            params.add("-Bstatic");
            params.add("-L./");
            params.add("-lwhile");
//            params.add("");
            callGCC(params, filename + ".exe");

            // delete temporary
            File toDel = new File(filepath.getFileName() + ".cpp");
            if (toDel.exists() && !toDel.isDirectory())
                toDel.delete();

            return true;

        } catch (RecognitionException recognitionException) {
            System.out.println(ANSI_RED + "Erreur de compilation!!!");
            System.out.println(recognitionException.getLocalizedMessage());

            return false;
        }
    }

    public void callGCC() throws IOException {
        callGCC("", "");
    }

    public void callGCC(String file, String output) throws IOException {
        callGCC(Arrays.asList(file.split(" ")), output);
    }

    public void callGCC(List<String> params, String output) throws IOException {
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
        Process p = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("Done.");
    }

    public void convert3AtoCPP(String mainFunc) {
        Convert convert = new Convert(getProgram(), symbolTable, mainFunc);
        cpp_output = convert.convert();
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

    public void saveProgram(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".w3a"));
        writer.write(getProgram().getProgramString().toLowerCase());
        writer.close();
    }
}
