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

        if (!succes) return;

        compiler.printProgram();

        BufferedWriter writer = new BufferedWriter(new FileWriter("compiled.w3a"));
        writer.write(compiler.getProgram().getProgramString().toLowerCase());

        writer.close();
    }
}