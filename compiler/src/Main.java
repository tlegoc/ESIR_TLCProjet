import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, RecognitionException {
        System.out.println("While Compiler v0.1a");

//        if (args.length <= 0) {
//            System.out.println("No input specified! Please input a file using -i FILE");
//            return;
//        }

        // Open file from first argument
//        String filename = args[0];

        String filename = "test1.while";

        CharStream input = new ANTLRFileStream(filename);

        whileLexer lex = new whileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        whileParser pars = new whileParser(tokens);

        whileParser.start_rule_return src = pars.start_rule();

        Object ast = src.getTree();

        //VisitorTS visitor = new VisitorTS(ast);
        //visitor.visit(ast);
    }
}