import ThreeAddr.Program;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class WhileCompiler {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private String filename;

    private VisitorTA visitor;

    private Program program;

    public WhileCompiler(String file)
    {
        filename = file;
    }

    public boolean compile(boolean runOptimizations) throws IOException {
        CharStream input = new ANTLRFileStream(filename);

        whileLexer lex = new whileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        whileParser pars = new whileParser(tokens);

        try {
            whileParser.start_rule_return src = pars.start_rule();

            Object ast = src.getTree();

            visitor = new VisitorTA();

            visitor.visit(ast);

            program = visitor.getProgram();

            if (runOptimizations)
                program.optimize();

            visitor.clean();
        } catch (RecognitionException recognitionException)
        {
            System.out.println(ANSI_RED + "Erreur de compilation!!!");
            System.out.println(recognitionException.getLocalizedMessage());

            return false;
        }


        return true;
    }

    public void printProgram()
    {
        if (program == null) System.out.println("Programme pas encore compilé. Veuillez appeller .compile()");
        System.out.println(program.getProgramString(true));
    }
}
