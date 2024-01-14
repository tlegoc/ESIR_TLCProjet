import Optimization.WhileOptimizer;
import SymbolTable.SymbolTable;
import ThreeAddr.Program;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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

        Path filepath = Paths.get(filename);

        try {
            CharStream input = new ANTLRFileStream(filename);

            whileLexer lex = new whileLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            whileParser pars = new whileParser(tokens);

            whileParser.start_rule_return src = pars.start_rule();

            ast = src.getTree();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error: could not open source file." + ANSI_RESET);
            return false;
        } catch (RecognitionException e) {
            System.out.println(ANSI_RED + "Error: unknown ANTLR runtime exception." + ANSI_RESET);
            System.out.println(e.getLocalizedMessage());
            return false;
        }

        // Creating symbol table and validation
        VisitorTS visitorTS = new VisitorTS();
        if (!visitorTS.visit(ast))
        {
            System.out.println(ANSI_RED + "Error: could not validate program" + ANSI_RESET);
            return false;
        }
        symbolTable = visitorTS.getST();

        if (symbolTable.getFunc("main") == null)
        {
            System.out.println(ANSI_RED + "Error: no main function." + ANSI_RESET);
            return false;
        }

//        symbolTable.printSymbolTable();

        // Creating intermediate code
        VisitorTA visitorTA = new VisitorTA();
        visitorTA.visit(ast);
        program = visitorTA.getProgram();

//        System.out.println(program.getProgramString(true));

        if (runOptimizations) {
            WhileOptimizer optimizer = new WhileOptimizer(program, symbolTable);
            program = optimizer.optimize();
        }

        CPPConverter cppConverter = new CPPConverter(getProgram(), symbolTable, mainFunc);
        cpp_output = cppConverter.convert();

        // If we don't want to compile to exe, we just write the cpp file next to the .while file
        if (!compileToExe) {
            // Copy cpp file next to the .while file
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filepath.toString() + ".cpp"));
                writer.write(cpp_output);
                writer.close();
            } catch (IOException e) {
                System.out.println(ANSI_RED + "Error: could not write .cpp file." + ANSI_RESET);
                return false;
            }
            return true;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath.getFileName() + ".cpp"));
            writer.write(cpp_output);
            writer.close();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error: could not write .cpp file." + ANSI_RESET);
            return false;
        }

        // Check if the library exists
        File lib = new File("./while.lib");

        if (!lib.exists()) {
            System.out.println(ANSI_RED + "Error: You must build the library first! If you're on windows, please run compile_windows.bat" + ANSI_RESET);
            clean();
            return false;
        }

        // Retrieve Visual Studio path on windows
        String compilerPath = "";
        if (System.getProperty("os.name").contains("Windows")) {
            // Check if we have a saved path
            File f = new File("vspath.tmp");
            if (f.exists() && !f.isDirectory()) {
                System.out.println("Found saved path in vspath.tmp");
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(f));
                    compilerPath = reader.readLine();
                    reader.close();
                } catch (IOException ignored) {
                }
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your visual studio installation folder:");
                compilerPath = sc.nextLine();
                // Save
                BufferedWriter writer;
                try {
                    writer = new BufferedWriter(new FileWriter("vspath.tmp"));
                    writer.write(compilerPath);
                    writer.close();
                } catch (IOException e) {
                    System.out.println(ANSI_RED + "Error: could not save vspath.tmp. You will have to enter it again next time." + ANSI_RESET);
                }
            }
        }

        // Appel du compilateur cpp
        List<String> commands = new ArrayList<>();
        System.out.println("Calling C++ compiler...");
        if (System.getProperty("os.name").contains("Windows")) {
            Path cp = Paths.get(compilerPath);
            Path vcvarsallpath = Paths.get(cp.toString(), "VC", "Auxiliary", "Build", "vcvarsall.bat");
            // Check if the file exists
            if (!vcvarsallpath.toFile().exists()) {
                System.out.println(ANSI_RED + "Error: could not find vcvarsall.bat in " + vcvarsallpath.toString() + ANSI_RESET);
                clean();
                return false;
            }

            commands.add("cmd");
            commands.add("/c");
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
            System.out.println("Running: \n" + commands.stream().reduce("", (a, b) -> a + " " + b));
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = p.waitFor();

            System.out.println("Compiler finished with exit code " + exitCode);

            if (exitCode != 0) {
                System.out.println(ANSI_RED + "Error: compiler returned non-zero exit code." + ANSI_RESET);
                clean();
                return false;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(ANSI_RED + "Error: unknown IO error - " + e.getLocalizedMessage() + ANSI_RESET);
            clean();
            return false;
        }

        clean();
        return true;
    }

    public void clean()
    {
        /*
        Path filepath = Paths.get(filename);

        // delete temporary

        File toDel = new File(filepath.getFileName() + ".cpp");
        if (toDel.exists() && !toDel.isDirectory())
            toDel.delete();
        toDel = new File(filepath.getFileName() + ".obj");
        if (toDel.exists() && !toDel.isDirectory())
            toDel.delete();

         */
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
