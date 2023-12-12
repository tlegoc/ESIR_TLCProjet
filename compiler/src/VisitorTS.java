import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
//import org.antlr.runtime.tree.TreeWizard;
import java.util.ArrayList;
import java.util.HashMap;

public class VisitorTS{
    SpaghettiStack ts = new SpaghettiStack();
    private void visitAux(Object o, SpaghettiStack actual){
        CommonTree tree = (CommonTree) o;
        switch (tree.toString()){
            case "FUNC", "FOR", "IF", "WHILE", "FOREACH","COMMANDS", "THEN":
                SpaghettiStack spagetti = new SpaghettiStack();
                actual.addChild(spagetti);
                for(int i =0; i<tree.getChildCount(); i++){
                    visitAux(tree.getChild(i), actual.getChild(actual.getChildrenCount()-1));
                }
            default:
                if(tree.getChildCount() == 0 &&
                        !tree.toString().equals("VIDE") &&
                        !tree.toString().equals("PARAM") ) {
                    actual.addToLine(tree.toString());
                }else{
                    for(int i =0; i<tree.getChildCount(); i++){
                        visitAux(tree.getChild(i), actual);
                    }
                }
        }
    }
    public void visit(Object o) {
        visitAux(o, ts);
    }
    public void display_ts() {
       System.out.println(ts.toString());
    }
}
