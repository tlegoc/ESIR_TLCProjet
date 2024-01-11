import java.io.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("While Compiler cyberviking 2019");

        if (args.length <= 0) {
            System.out.println("Wrong numbers of parameters. Please input FILE [MAIN_FUNCTION_NAME].");
            return;
        }

        String filename = args[0];
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("Error: input doesn't exist.");
        } else if (f.isDirectory()) {
            System.out.println("Error: input is a directory");
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
            System.out.println("Error, could not compile program");
            return;
        }
    }
}