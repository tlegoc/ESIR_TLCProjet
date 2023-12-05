import ThreeAddr.*;
import org.antlr.runtime.tree.CommonTree;

import java.util.Objects;

public class VisitorTA {
    private Program program = new Program();

    public Argument visit(Object o) {
        CommonTree tree = (CommonTree) o;
        String token = String.valueOf(tree);
//        System.out.println("Visiting " + token);

        switch (token) {
            case "CONS":
                int childCount = tree.getChildCount();
                Registre cons_res = new Registre();
                switch (childCount) {
                    case 2:
                        Argument arg1 = visit(tree.getChild(0));
                        Argument arg2 = visit(tree.getChild(1));
                        program.addLine(Line.Op.CONS, cons_res, arg1, arg2);
                        break;
                    case 1:
                        Argument arg = visit(tree.getChild(0));
                        if (arg instanceof Symbol && Objects.equals(((Symbol) arg).name, "VIDE")) {
                            program.addLine(Line.Op.CONS, cons_res);
                            break;
                        }
                        program.addLine(Line.Op.CONS, cons_res, arg, new EmptyArgument());
                        break;

                    // Should never happen
                    default:
                        program.addLine(Line.Op.CONS, cons_res);
                        break;
                }
                return cons_res;
            case "ASSIGN":
                Argument egal_res = visit(tree.getChild(0));
//                if (!(egal_res instanceof Symbol)) {
//                    throw new RuntimeException("Error: cannot process assignation.");
//                }
                Argument egal_arg = visit(tree.getChild(1));
                program.addLine(Line.Op.ASSIGN, egal_res, egal_arg, new EmptyArgument());
                break;
            case "COMMANDS":
            case "BODY":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                break;
            case "FUNC":
                program.addLine(Line.Op.FUNCBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                // Body
                visit(tree.getChild(1));
                program.addLine(Line.Op.FUNCEND, new Symbol(String.valueOf(tree.getChild(0))));
                break;
            case "OUTPUT":
                program.addLine(Line.Op.RETURN, new Symbol(String.valueOf(tree.getChild(0))));
                break;
            case "PARAM":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    String p = String.valueOf(tree.getChild(i));
                    program.addLine(Line.Op.PARAM, new Symbol(p));
                }
                break;
            case "FOR":
                program.addLine(Line.Op.FORBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                visit(tree.getChild(1));
                program.addLine(Line.Op.FOREND, new Symbol(String.valueOf(tree.getChild(0))));
                break;
            case "TL":
                Argument tl_arg = visit(tree.getChild(0));
                Registre tl_res = new Registre();
                program.addLine(Line.Op.TL, tl_res, tl_arg, new EmptyArgument());
                return tl_res;
            case "HD":
                Argument hd_arg = visit(tree.getChild(0));
                Registre hd_res = new Registre();
                program.addLine(Line.Op.HD, hd_res, hd_arg, new EmptyArgument());
                return hd_res;

            // Symbol is actually a function call
            case "SYMBOL":
                for (int i = 1; i < tree.getChildCount(); i++) {
                    Argument param_v = visit(tree.getChild(i));
                    program.addLine(Line.Op.PARAMSET, param_v);
                }
                Registre fc_res = new Registre();
                program.addLine(Line.Op.CALL, fc_res, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument());
                return fc_res;

            case "LIST":
                // Pour simplifier la tache, on convertis directement LIST en appels de CONS
                // Evite de coder des fonctions à nombre de paramètres indéterminés.

                // USED IN DEBUGGING
                //TODO REMOVE
                program.addComment("LIST CONVERSION START");

                Registre ls_res = new Registre();
                program.addLine(Line.Op.ASSIGN, ls_res, new Symbol("nil"), new EmptyArgument());
                for (int i = tree.getChildCount() - 1; i >= 0; i--) {
                    Registre tmp = new Registre();
                    program.addLine(Line.Op.CONS, tmp, visit(tree.getChild(i)), ls_res);
                    ls_res = tmp;
                }

                // USED IN DEBUGGING
                //TODO REMOVE
                program.addComment("LIST CONVERSION END (result in " + ls_res.name + ")");
                return ls_res;
            case "WHILE":
                program.addLine(Line.Op.WHILEBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                visit(tree.getChild(1));
                program.addLine(Line.Op.WHILEEND, new Symbol(String.valueOf(tree.getChild(0))));
                break;
            default:
                // Edge case for root program leaf
                // Should not give any problems since any leaf node with "nil"
                // will not have any child except for the root one.
                if (token.equals("nil")) {
                    for (int i = 0; i < tree.getChildCount(); i++) {
                        visit(tree.getChild(i));
                    }
                }
                return new Symbol(token);
        }

        return new EmptyArgument();
    }

    public Program getProgram() {
        return program;
    }

    public void clean()
    {
        program = null;
    }
}
