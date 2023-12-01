import org.antlr.runtime.tree.CommonTree;

public class VisitorTest extends WhileASTVisitor {
    
    @Override
    public void process(CommonTree o) {
        System.out.println(o);
    }
}
