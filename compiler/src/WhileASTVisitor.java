import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeWizard;

public abstract class WhileASTVisitor extends TreeWizard.Visitor {
    @Override
    public void visit(Object o) {
        CommonTree tree = (CommonTree) o;

        processBegin(tree);
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            visit(tree.getChild(i));
        }
        processEnd(tree);
    }

    public abstract void processBegin(CommonTree o);
    public abstract void processEnd(CommonTree o);

}
