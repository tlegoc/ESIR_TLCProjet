import org.antlr.runtime.tree.CommonTree;

public class VisitorTest extends WhileASTVisitor {

    @Override
    public void processBegin(CommonTree o) {
        System.out.println(o);
    }

    @Override
    public void processEnd(CommonTree o) {

    }
}
