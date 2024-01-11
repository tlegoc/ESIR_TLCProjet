import SymbolTable.*;
import org.antlr.runtime.tree.CommonTree;

public class VisitorTS {

    private final SymbolTable st = new SymbolTable();

    public SymbolTable getST() {
        return st;
    }

    public void visit(Object o) {
        CommonTree tree = (CommonTree) o;
        String token = tree.toString();

        switch (token) {
            case "FUNC":
                st.add(new STBlockStart());
                CommonTree body = (CommonTree) tree.getChild(1);
                CommonTree par = (CommonTree) body.getChild(0);
                CommonTree out = (CommonTree) body.getChild(2);
                int param_count = par.getChildCount();
                int output_count = out.getChildCount();
                String[] parameters = new String[param_count];
                String[] outputs = new String[output_count];

                for (int i = 0; i < param_count; i++)
                {
                    parameters[i] = par.getChild(i).toString();
                }

                for (int i = 0; i < output_count; i++)
                {
                    outputs[i] = out.getChild(i).toString();
                }
                //ajout de la func dans la TS
                st.add(new STFunc(tree.getChild(0).toString(), parameters, outputs));
                visit(body);
                st.add(new STBlockEnd());
                break;
            case "BODY":
                visit(tree.getChild(2));
                break;
            case "COMMANDS":
                st.add(new STBlockStart());
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                st.add(new STBlockEnd());
                break;
            case "ASSIGN":
                for (int i = 0; i < tree.getChild(0).getChildCount(); i++)
                    /*TODO : checker pour chaque variables du bloc ASSIGN_VARS si il ne sont pas déja dans la TS dans ce bloc et les blocs du dessus
                    Spoiler, compliqué
                    */
                    st.add(new STVariable(tree.getChild(0).getChild(i).toString(), false));
                break;
            default:
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                break;
        }
    }
}
