import ThreeAddr.*;
import org.antlr.runtime.tree.CommonTree;

public class VisitorTA {
    private Program program = new Program();

    public Argument visit(Object o) {
        CommonTree tree = (CommonTree) o;
        String token = String.valueOf(tree);
        System.out.println("Visiting " + token);

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
                        program.addLine(Line.Op.CONS, cons_res, arg, new EmptyArgument());
                        break;
                    default:
                        program.addLine(Line.Op.CONS, cons_res, new EmptyArgument(), new EmptyArgument());
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
                program.addLine(Line.Op.FUNCBEGIN, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument(), new EmptyArgument());
                // Body
                visit(tree.getChild(1));
                program.addLine(Line.Op.FUNCEND, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument(), new EmptyArgument());
                break;
            case "OUTPUT":
                program.addLine(Line.Op.RETURN, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument(), new EmptyArgument());
                break;
            case "PARAM":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    String p = String.valueOf(tree.getChild(i));
                    program.addLine(Line.Op.PARAM, new Symbol(p), new EmptyArgument(), new EmptyArgument());
                }
                break;
            case "FOR":
                program.addLine(Line.Op.FORBEGIN, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument(), new EmptyArgument());
                visit(tree.getChild(1));
                program.addLine(Line.Op.FOREND, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument(), new EmptyArgument());
                break;
            case "TL":
                Argument tl_arg = visit(tree.getChild(0));
                Registre tl_res = new Registre();
                program.addLine(Line.Op.TL, tl_res, tl_arg, new EmptyArgument());
                return tl_res;
            case "HD":
                Argument hd_arg = visit(tree.getChild(0));
                Registre hd_res = new Registre();
                program.addLine(Line.Op.TL, hd_res, hd_arg, new EmptyArgument());
                return hd_res;
            case "SYMBOL":
                for (int i = 1; i < tree.getChildCount(); i++) {
                    Argument param_v = visit(tree.getChild(i));
                    program.addLine(Line.Op.PARAMSET, param_v, new EmptyArgument(), new EmptyArgument());
                }
                Registre fc_res = new Registre();
                program.addLine(Line.Op.CALL, fc_res, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument());
                return fc_res;
            default:
                if (token.compareTo("nil") == 0) {
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
}
