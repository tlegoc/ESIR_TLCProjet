import java.io.*;


public class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        System.out.println("While Compiler cyberviking 2019");

        if (Main.class.getResource("Main.class").toString().startsWith("jar")) {
            // Extract resources from jar and put it next to the jar

        } else {
            System.out.println(ANSI_RED + "Running from IDE" + ANSI_RESET);
        }

        if (args.length <= 0) {
            System.out.println(ANSI_RED + "Error: Wrong numbers of parameters. Please add FILEPATH as an argument." + ANSI_RESET);
            return;
        }

        String filename = args[0];
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println(ANSI_RED + "Error: input doesn't exist." + ANSI_RESET);
        } else if (f.isDirectory()) {
            System.out.println(ANSI_RED + "Error: input is a directory" + ANSI_RESET);
        }
        String main;
        /*
        if (args.length > 1) main = args[1];
        else main = "main";
         */
        main = "main";
        System.out.println("Compiling " + filename + " with main function " + main);

        WhileCompiler compiler = new WhileCompiler(f.getAbsolutePath());

        boolean succes = compiler.compile(main, true, false);

        if (!succes) {
            System.out.println(ANSI_RED + "Error, could not compile program" + ANSI_RESET);
            return;
        }
    }
}