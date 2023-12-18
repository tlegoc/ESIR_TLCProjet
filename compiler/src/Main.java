import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import java.lang.reflect.Array;
import java.util.ArrayList;
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

//        compiler.printProgram();
        compiler.printSymbolTable();
//        compiler.saveProgram(filename);

    }
}