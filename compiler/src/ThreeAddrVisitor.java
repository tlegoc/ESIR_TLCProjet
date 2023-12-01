import ThreeAddr.*;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;
import java.util.List;

public class ThreeAddrVisitor extends WhileASTVisitor {

    private Program program = new Program();

    @Override
    public void visit(Object o) {
        CommonTree tree = (CommonTree) o;

        preprocess(tree);
        for (int i = 0; i < tree.getChildCount(); i++) {
            visit(tree.getChild(i));
        }
        process(tree);
    }

    public void preprocess(CommonTree tree) {

    }

    @Override
    public void process(CommonTree o) {
        String token = String.valueOf(o);

        switch (token) {
            case "CONS":
                if (o.getChildCount() == 0)
                    program.addLine(new Line(Line.Op.EGALITE, new Registre(), new Constante("nil"), new EmptyArgument()));
                else if (o.getChildCount() == 1)
                    program.addLine(new Line(Line.Op.EGALITE, new Registre(), program.getLastLine(0).arg1, new EmptyArgument()));
                else if (o.getChildCount() == 2) System.out.println("PAS BON");
                break;
            default:
                break;
        }
    }

    public Program getProgram() {
        return program;
    }
}
