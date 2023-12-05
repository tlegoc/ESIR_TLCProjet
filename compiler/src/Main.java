
import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("While Compiler alpha");

        if (args.length <= 0) {
            System.out.println("No input specified! Please input a file using -i FILE");
            return;
        }

        String filename = args[0];

        WhileCompiler compiler = new WhileCompiler(filename);

        compiler.compile(true);

        compiler.printProgram();
    }
}