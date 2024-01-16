import Optimization.WhileOptimizer;
import SymbolTable.SymbolTable;
import ThreeAddr.Program;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.*;
import java.nio.file.Files;
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
    public boolean compile(boolean compileToExe, boolean runOptimizations) {
        Object ast;
        Path filepath = Paths.get(filename);
        boolean isWindows = System.getProperty("os.name").contains("Windows");

        // Generate AST
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
        if (!visitorTS.visit(ast)) {
            System.out.println(ANSI_RED + "Error: could not validate program" + ANSI_RESET);
            return false;
        }
        symbolTable = visitorTS.getST();

        // Check if main function exists
        if (symbolTable.getFunc("main") == null) {
            System.out.println(ANSI_RED + "Error: no main function." + ANSI_RESET);
            return false;
        }


        // Creating intermediate code
        VisitorTA visitorTA = new VisitorTA();
        visitorTA.visit(ast);
        program = visitorTA.getProgram();


        // Optimizing
        if (runOptimizations) {
            printProgram();
            WhileOptimizer optimizer = new WhileOptimizer(program, symbolTable);
            program = optimizer.optimize();
            System.out.println("=============================================");
            System.out.println("=============================================");
            System.out.println("=============================================");
            printProgram();
        }


        // Creating C++ code
        CPPConverter cppConverter = new CPPConverter(getProgram(), symbolTable);
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


        // Pre compilation steps
        Path workingDir;
        Path libPath;

        // If we're in a jar, we need to extract the resources
        if (Main.class.getResource("Main.class").toString().startsWith("jar")) {
            // Create temporary directory, avoiding collisions
            try {
                workingDir = Files.createTempDirectory("whilec").toAbsolutePath();
            } catch (IOException e) {
                System.out.println(ANSI_RED + "Error: could not create temporary directory." + ANSI_RESET);
                return false;
            }

            // Extract resources from jar and put it next to the jar
            // Copy lib from resources to tmpDir
            String resource = "libwhile.a.res";
            if (isWindows)
                resource = "while.lib.res";

            libPath = Paths.get(workingDir.toString() , "libwhile.a");
            if (isWindows)
                libPath = Paths.get(workingDir.toString() , "while.lib");

            if (extractResource(resource, libPath)) return false;

            if (extractResource("lib_while.h", Paths.get(workingDir.toString(), "lib_while.h"))) return false;

        // We're in the IDE so we can just use the files that are created next to the jar (compile_windows.bat)
        } else {
            workingDir = Paths.get(".").toAbsolutePath();

            libPath = Paths.get(workingDir.toString(), "libwhile.a");
            if (isWindows)
                libPath = Paths.get(workingDir.toString(), "while.lib");

            File lib = new File(libPath.toAbsolutePath().toString());
            File header = new File(workingDir.toAbsolutePath().toString() + "/lib_while.h");

            if (!lib.exists() || !header.exists()) {
                System.out.println(ANSI_RED + "Error: You must build the library first! If you're on windows, please run compile_windows.bat, or compile_linux.sh on Linux." + ANSI_RESET);
                return false;
            }

        }

        // Writing cpp file
        Path cppFilePath = Paths.get(workingDir.toAbsolutePath().toString(), filepath.getFileName() + ".cpp");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(cppFilePath.toString()));
            writer.write(cpp_output);
            writer.close();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error: could not write .cpp file." + ANSI_RESET);
            return false;
        }

        // Retrieve Visual Studio path on windows
        String compilerPath = "";
        if (isWindows) {
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
        if (isWindows) {
            Path cp = Paths.get(compilerPath);
            Path vcvarsallpath = Paths.get(cp.toString(), "VC", "Auxiliary", "Build", "vcvarsall.bat");
            // Check if the file exists
            if (!vcvarsallpath.toFile().exists()) {
                System.out.println(ANSI_RED + "Error: could not find vcvarsall.bat in " + vcvarsallpath.toString() + ANSI_RESET);
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

            commands.add(cppFilePath.toAbsolutePath().toString());

            // Useless
//            commands.add("/I");
//            commands.add("./");

            commands.add("/o");
            commands.add(filepath + ".exe");

            commands.add("/link");
            commands.add(libPath.toAbsolutePath().toString());

        } else {
            commands.add("g++");

            commands.add(cppFilePath.toAbsolutePath().toString());

            commands.add("-o");
            commands.add(filepath.toString().substring(0, filepath.toString().lastIndexOf('.')));

            commands.add("-Bstatic");
            commands.add("-L" + libPath.toAbsolutePath().getParent());
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
                return false;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(ANSI_RED + "Error: unknown IO error - " + e.getLocalizedMessage() + ANSI_RESET);
            return false;
        }

        return true;
    }

    private boolean extractResource(String resource, Path outRes) {
        try (InputStream in = getClass().getResourceAsStream(resource)) {
            System.out.println("Copying library to " + outRes);
            if (in != null)
                Files.copy(in, outRes);
            else {
                System.out.println(ANSI_RED + "Error: could not copy " + resource + " to temporary directory." + ANSI_RESET);
                return true;
            }
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error: could not copy " + resource + " to temporary directory." + ANSI_RESET);
            return true;
        }
        return false;
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
