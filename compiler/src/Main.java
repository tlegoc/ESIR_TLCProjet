import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        System.out.println("While Compiler cyberviking 2019");

        if (args.length <= 0) {
            System.out.println(ANSI_RED + "Error: Wrong numbers of parameters. Please add FILEPATH as an argument." + ANSI_RESET);
            return;
        }

        String filename = args[0];
        Path filenamePath = Paths.get(filename);
        File f = filenamePath.toFile();
        if (!f.exists()) {
            System.out.println(ANSI_RED + "Error: input " + filenamePath.toAbsolutePath() + " doesn't exist." + ANSI_RESET);
        } else if (f.isDirectory()) {
            System.out.println(ANSI_RED + "Error: input is a directory" + ANSI_RESET);
        }

        System.out.println("Compiling " + filename);

        WhileCompiler compiler = new WhileCompiler(f.getAbsolutePath());
        //optimization broken for the moment
        boolean succes = compiler.compile(true, false);

        // Vous pouvez décommenter pour afficher le code 3 adresses et la table des symboles.
//        compiler.printProgram();
//        compiler.printSymbolTable();

        if (!succes) {
            System.out.println(ANSI_RED + "Error: could not compile program" + ANSI_RESET);
            return;
        }
    }
}