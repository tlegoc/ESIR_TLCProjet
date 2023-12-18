import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("While Compiler alpha");

        if (args.length <= 0) {
            System.out.println("No input specified! Please input a file.");
            return;
        }

        String filename = args[0];
        System.out.println("Compiling " + filename);

        WhileCompiler compiler = new WhileCompiler(filename);

        boolean succes = compiler.compile(true);

        if (!succes) {
            System.out.println("Error");
            return;
        }

        compiler.printProgram();
//        compiler.saveProgram(filename);
    }
}