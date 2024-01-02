import ThreeAddr.Program;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.*;
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
    private SpaghettiStack SymbolsTable;

    private String output;

    public WhileCompiler(String file) {
        filename = file;
    }

    public boolean compile(boolean runOptimizations) throws IOException {
        if (!isGccInstalled()) return false;

        CharStream input = new ANTLRFileStream(filename);

        whileLexer lex = new whileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        whileParser pars = new whileParser(tokens);

        try {
            whileParser.start_rule_return src = pars.start_rule();

            Object ast = src.getTree();

            visitorTA = new VisitorTA();

            visitorTA.visit(ast);

            program = visitorTA.getProgram();

            if (runOptimizations) program.optimize();

            // COMPILATION EN C PUIS APPEL DE GCC
            List<String> params = new ArrayList<>();
            params.add("test.cpp");
            params.add("-Bstatic");
            params.add("-Llibwhile");
//            params.add("");
            callGCC(params, "test");

            visitorTA.clean();

            visitorTS = new VisitorTS();
            visitorTS.visit(ast);

            SymbolsTable = visitorTS.get_ts();

        } catch (RecognitionException recognitionException) {
            System.out.println(ANSI_RED + "Erreur de compilation!!!");
            System.out.println(recognitionException.getLocalizedMessage());

            return false;
        }


        return true;
    }

    public void callGCC() throws IOException {
        callGCC("", "");
    }

    public void callGCC(String file, String output) throws IOException {
        callGCC(Arrays.asList(file.split(" ")), output);
    }

    public void callGCC(List<String> params, String output) throws IOException {
        System.out.println("---\tGCC");
        List<String> command = new ArrayList<>();
        if (System.getProperty("os.name").contains("Windows")) {
            command.add("cmd");
            command.add("/c");
            command.add("g++");
        } else command.add("g++");

        if (!output.isEmpty()) {
            command.add("-o");
            command.add(output);
        }

        command.addAll(params);

        ProcessBuilder pb = new ProcessBuilder();
        pb.command(command);
        pb.redirectErrorStream(true);
        Process p = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("---");
    }

    public void convert3AtoCPP(){
        Convert convert = new Convert(getProgram());
        output = convert.convert();
    }

    public void printProgram() {
        if (program == null) System.out.println("Programme pas encore compilé. Veuillez appeller .compile()");
        System.out.println(program.getProgramString(true));
    }

    public void printSymbolTable()
    {
        System.out.println(SymbolsTable);
    }

    public Program getProgram() {
        return program;
    }

    public Boolean isGccInstalled() {
        return true;
    }

    public void saveProgram(String name) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".w3a"));
        writer.write(getProgram().getProgramString().toLowerCase());
        writer.close();
    }

    public void saveCPP(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".cpp"));
        writer.write(output);
        writer.close();
    }
}
