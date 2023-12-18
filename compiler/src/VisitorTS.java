import Info.FuncInfo;
import Info.VarInfo;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
//import org.antlr.runtime.tree.TreeWizard;
import java.util.ArrayList;
import java.util.HashMap;

public class VisitorTS {
    SpaghettiStack ts = new SpaghettiStack();

    private void visitAux(Object o, SpaghettiStack actual) {
        CommonTree tree = (CommonTree) o;
        String token = tree.toString();

        if (token.equals("FUNC")) {
            String ID = String.valueOf(tree.getChild(0));
            tree = (CommonTree) tree.getChild(1);
            int inputs = tree.getChild(0).getChildCount();
            int outputs = tree.getChild(2).getChildCount();
            FuncInfo func = new FuncInfo(ID, inputs, outputs);
            actual.addToLine(func);
            SpaghettiStack block = new SpaghettiStack();
            actual.addChild(block);
            actual = block;
            for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
                String id = tree.getChild(0).getChild(i).toString();
                VarInfo param = new VarInfo(id, true);
                actual.getLine().add(param);
            }
            for (int i = tree.getChild(1).getChildCount() - 1; i >= 0; i--) {
                visitAux(tree.getChild(1).getChild(i), actual);
            }
        } else if (token.equals("COMMANDS")) {
            SpaghettiStack block = new SpaghettiStack();
            actual.addChild(block);
            actual = block;
            for (int i = 0; i < tree.getChildCount(); i++) {
                visitAux(tree.getChild(i), actual);
            }
        } else if (token.equals("PARAM")) {
            for (int i = 0; i < tree.getChildCount(); i++) {
                String id = tree.getChild(i).toString();
                VarInfo param = new VarInfo(id, true);
                actual.getChild(0).getLine().add(param);
            }
        } else if (token.equals("ASSIGN")) {
            String n = tree.getChild(0).toString(); // la variable declaree / modifiee
            VarInfo info = new VarInfo(n, false);
            boolean isDeclared = false;
            for (int i = 0; i < actual.getLine().size(); i++) {
                if (actual.getLine().get(i).ID.equals(n)) {
                    isDeclared = true;
                    break;
                }
            }
            if (!isDeclared) actual.addToLine(info);
        } else {
            for (int i = 0; i < tree.getChildCount(); i++) {
                visitAux(tree.getChild(i), actual);
            }
        }
    }

    public void visit(Object o) {
        visitAux(o, ts);
    }

    public void display_ts() {
        System.out.println(ts.toString());
    }

    public SpaghettiStack get_ts() {
        return ts;
    }
}
