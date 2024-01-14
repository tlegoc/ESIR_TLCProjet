import SymbolTable.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class VisitorTS {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private final SymbolTable st = new SymbolTable();
    private boolean valid = true;

    public SymbolTable getST() {
        return st;
    }

    /**
     * Visite l'ast afin de construire la table des symboles.
     *
     * @param o objet racine
     * @return false si le programme est invalide, vrai sinon.
     */
    public boolean visit(Object o) {
        CommonTree tree = (CommonTree) o;
        String token = tree.toString();

        switch (token) {
            case "FUNC":
                String func_name = tree.getChild(0).toString();
                CommonTree body = (CommonTree) tree.getChild(1);
                CommonTree par = (CommonTree) body.getChild(0);
                CommonTree out = (CommonTree) body.getChild(2);
                int param_count = par.getChildCount();
                int output_count = out.getChildCount();
                String[] parameters = new String[param_count];
                String[] outputs = new String[output_count];

                for (int i = 0; i < param_count; i++) {
                    parameters[i] = par.getChild(i).toString();
                }

                for (int i = 0; i < output_count; i++) {
                    outputs[i] = out.getChild(i).toString();
                }

                if (st.getFunc(func_name) != null) {
                    System.out.println(ANSI_RED + "Error: redefinition of " + tree.getChild(0).toString() + " at " + Helpers.getFormattedPosition(tree.getChild(0)) + ANSI_RESET);
                    valid = false;
                }

                //ajout de la func dans la TS
                st.add(new STBlockStart());
                st.add(new STFunc(func_name, parameters, outputs));
                visit(body);
                st.add(new STBlockEnd());

                break;
            case "BODY":
                visit(tree.getChild(1));
                break;
            case "COMMANDS":
                st.add(new STBlockStart());
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                st.add(new STBlockEnd());
                break;
            case "ASSIGN":
                int count = tree.getChild(0).getChildCount();
                for (int i = 0; i < count; i++)
                    st.add(new STVariable(tree.getChild(0).getChild(i).toString()));

                // Count the number of outputs in assign right op
                int right_count = 0;
                for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
                    Tree expr = tree.getChild(1).getChild(i).getChild(0);
                    if (expr.toString().equals("CALL")) {
                        String func_name2 = String.valueOf(expr.getChild(0));
                        STFunc func = st.getFunc(func_name2);
                        if (func != null) right_count += func.outputs.length;
                    } else {
                        right_count++;
                    }
                    visit(expr);
                }

                if (count != right_count) {
                    System.out.println(ANSI_RED + "Error: right part of assignment is of incorrect size " + right_count + ", expected " + count + " at " + Helpers.getFormattedPosition(tree.getChild(0)) + ANSI_RESET);
                    valid = false;
                }

                break;
            case "VARIABLE":
//                System.out.println(ANSI_RED + "VARIABLE " + Helpers.getFormattedPosition(tree) + ANSI_RESET);
//                System.out.println("Scope: " + (st.getScopeCount() - 1));
                List<STEntry> entries = st.getAccessibleEntries(st.getScopeCount() - 1, true, true);

                // map to string
                List<String> entries_str = new ArrayList<>();
                for (STEntry entry : entries) {
                    entries_str.add(entry.getSymbol());
//                    System.out.println(entry.getSymbol());
                }

                if (!entries_str.contains(tree.getChild(0).toString())) {
                    System.out.println(ANSI_RED + "Error: use of undeclared variable " + tree.getChild(0).toString() + " at " + Helpers.getFormattedPosition(tree.getChild(0)) + ANSI_RESET);
                    valid = false;
                }
                break;
            case "CALL":
                String func_name2 = String.valueOf(tree.getChild(0));
                STFunc func = st.getFunc(func_name2);

                if (func == null) {
                    System.out.println(ANSI_RED + "Error: call to unknown function " + func_name2 + " at " + Helpers.getFormattedPosition(tree.getChild(0)) + ANSI_RESET);
                    valid = false;
                }

                int paramCount = tree.getChildCount() - 1;
                // get the number of parameters
                if (tree.getChild(1).toString().equals("VIDE")) paramCount = 0;

                if (func != null && func.parameters.length != paramCount)
                {
                    System.out.println(ANSI_RED + "Error: call to function " + func_name2 + " with wrong numbers of parameters, got " + (tree.getChildCount() - 1) + ", expected " + func.parameters.length + " at " + Helpers.getFormattedPosition(tree.getChild(0)) + ANSI_RESET);
                    valid = false;
                }

                for (int i = 1; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                break;
            case "FOREACH":
                // Check if variable is already declared
                visit(tree.getChild(1));
                // Foreach must add its variable to the symbol table, so we process
                // COMMANDS differently
                st.add(new STBlockStart());
                st.add(new STVariable(tree.getChild(0).getChild(0).toString()));
                for (int i = 0; i < tree.getChild(2).getChildCount(); i++) {
                    visit(tree.getChild(2).getChild(i));
                }
                st.add(new STBlockEnd());
                break;
            default:
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                break;
        }

        return valid;
    }
}
