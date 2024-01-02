import SymbolTable.*;
import org.antlr.runtime.tree.CommonTree;

public class VisitorTS {

    private SymbolTable st = new SymbolTable();

    public SymbolTable getST()
    {
        return st;
    }

    public void visit(Object o) {
        CommonTree tree = (CommonTree) o;
        String token = tree.toString();

        switch (token) {
            case "FUNC":
                st.add(new STFunc(tree.getChild(0).toString(), tree.getChild(1).getChild(0).getChildCount(), tree.getChild(1).getChild(2).getChild(0).toString()));
                visit(tree.getChild(1));
                break;
            case "BODY":
                st.add(new STBlockStart());
                visit(tree.getChild(0));

                for (int i = 0; i < tree.getChild(1).getChildCount(); i++)
                {
                    visit(tree.getChild(1).getChild(i));
                }
                st.add(new STBlockEnd());
                break;
            case "COMMANDS":
                st.add(new STBlockStart());
                for (int i = 0; i < tree.getChildCount(); i++)
                {
                    visit(tree.getChild(i));
                }
                st.add(new STBlockEnd());
                break;
            case "PARAM":
                for (int i = 0; i < tree.getChildCount(); i++)
                {
                    st.add(new STVariable(tree.getChild(i).toString()));
                }
                break;
            case "ASSIGN":
                st.add(new STVariable(tree.getChild(0).toString()));
                break;
            default:
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                break;
        }
    }
}
