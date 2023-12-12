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
            case "FUNC":
                SpaghettiStack spagetti = new SpaghettiStack();
                actual.addChild(spagetti);
                actual.addToLine(tree.getChild(0).toString()); // Le nom de la fonction
                actual = spagetti;
                tree = (CommonTree) tree.getChild(1);
                actual.addToLine(String.valueOf(tree.getChild(0).getChildCount())); // nombre de parametres
                actual.addToLine(String.valueOf(tree.getChild(2).getChildCount())); // nombre de retours
                for(int i =0; i<tree.getChild(0).getChildCount(); i++){
                    actual.addToLine(tree.getChild(0).getChild(i).toString()); // les parametres
                }
                tree = (CommonTree) tree.getChild(1); // Le bloc
                for(int i =0; i<tree.getChildCount(); i++){
                    visitAux(tree.getChild(i), actual);
                }
                break;
            case "FOR" :
                spagetti = new SpaghettiStack();
                actual.addChild(spagetti);
                actual = spagetti;
                tree = (CommonTree) tree.getChild(1);
                for(int i =0; i<tree.getChildCount(); i++){
                    visitAux(tree.getChild(i), actual);
                }
                break;
            case "ASSIGN" :
                String n = tree.getChild(0).toString();
                if(!actual.getLine().contains(n)) actual.addToLine(n);
                break;
            default:
                for(int i =0; i<tree.getChildCount(); i++){
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
}
