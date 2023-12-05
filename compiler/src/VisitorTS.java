import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
//import org.antlr.runtime.tree.TreeWizard;
import java.util.ArrayList;
import java.util.HashMap;

public class VisitorTS{
    SpaghettiStack ts = new SpaghettiStack();
    SpaghettiStack actual = null;
    public void visit(Object o){
        CommonTree tree = (CommonTree) o;
        switch (tree.getText()){
            case "FUNC", "FOR", "IF", "WHILE", "FOREACH","COMMANDS", "THEN":
                SpaghettiStack spagetti = new SpaghettiStack();
                actual = spagetti;
                ts.addChild(spagetti);
                for(int i =0; i<tree.getChildCount(); i++){
                    visit(tree.getChild(i));
                    actual = spagetti;
                }
                break;
            case "PARAMS", "OUTPUT", "ASSIGNATION", "CONS", "TL", "SYMBOL":
                for(int i =0; i<tree.getChildCount(); i++){
                    if(!tree.getChild(i).getText().equals("TL") || !tree.getChild(i).getText().equals( "CONS") || !tree.getChild(i).getText().equals("SYMBOL"))
                        actual.addToLine(tree.getChild(i).getText());
                }
                break;

            default:
                for(int i =0; i<tree.getChildCount(); i++){
                    visit(tree.getChild(i));
                }
                break;
        }
    }


    public void build_ts() {

    }
}
