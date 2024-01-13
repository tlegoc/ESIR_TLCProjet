import ThreeAddr.*;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// S'occupe de creer le code intermediaire
// Pourrait etre BEAUCOUP plus optimise
// mais il marche
public class VisitorTA {
    private final Program program = new Program();

    private final HashMap<String, Integer> functionOutputs = new HashMap<>();

    /***
     * Parcours l'AST pour generer le code 3 adresses
     * @param o L'arbre
     */
    public void visit(Object o) {
        CommonTree tree = (CommonTree) o;
        int line = tree.getLine();
        int charInLine = tree.getCharPositionInLine();
        //program.addComment("Line: " + line + ":" + charInLine + " (visit)");
        String token = String.valueOf(tree);
        switch (token) {
            case "CONS":
                program.addLine(Line.Op.CONS, processCONS(o), new EmptyArgument(), new EmptyArgument());
                break;
            case "ASSIGN":
                processASSIGN(o);
                break;
            case "FUNC":
                String funcName = String.valueOf(tree.getChild(0));
                int outCount = tree.getChild(1).getChild(2).getChildCount();
                functionOutputs.put(funcName, outCount);
                program.addLine(Line.Op.FUNCBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                visit(tree.getChild(1));
                program.addLine(Line.Op.FUNCEND, new Symbol(String.valueOf(tree.getChild(0))));
                break;
            case "COMMANDS":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                break;
            case "BODY":
                visit(tree.getChild(1));
                break;
            case "FOR":
                Registre cond_for = process(tree.getChild(0)).get(0);
                program.addLine(Line.Op.FORBEGIN, cond_for);
                visit(tree.getChild(1));
                program.addLine(Line.Op.FOREND, cond_for);
                break;
            case "FOREACH":
                Registre var_foreach = process(tree.getChild(0)).get(0);
                Registre cond_foreach = process(tree.getChild(1)).get(0);
                program.addLine(Line.Op.FOREACHBEGIN, var_foreach, cond_foreach, new EmptyArgument());
                visit(tree.getChild(2));
                program.addLine(Line.Op.FOREACHBEGIN, var_foreach, cond_foreach, new EmptyArgument());
                break;
            case "LIST":
                program.addLine(Line.Op.ASSIGN, new Registre(), processLIST(o), new EmptyArgument());
                break;
            case "WHILE":
                Argument cond_while = process(tree.getChild(0)).get(0);
                program.addLine(Line.Op.WHILEBEGIN, cond_while);
                visit(tree.getChild(1));
                program.addLine(Line.Op.WHILEEND, cond_while);
                break;
            case "IF":
                Argument condition = process(tree.getChild(0)).get(0);
                program.addLine(Line.Op.IFBEGIN, condition);
                visit(tree.getChild(1));
                program.addLine(Line.Op.IFEND, condition);
                if (tree.getChildCount() > 2) {
                    program.addLine(Line.Op.ELSEBEGIN, condition);
                    visit(tree.getChild(2));
                    program.addLine(Line.Op.ELSEEND, condition);
                }
                break;
            default:
                if (token.equals("nil")) {
                    for (int i = 0; i < tree.getChildCount(); i++) {
                        visit(tree.getChild(i));
                    }
                }
                break;
        }
    }
    //TODO : FOREACH (eh ouais on l'a zappé)
    private List<Registre> process(Object o) {
        CommonTree tree = (CommonTree) o;
        int line = tree.getLine();
        int charInLine = tree.getCharPositionInLine();
        //program.addComment("Line: " + line + ":" + charInLine);
        List<Registre> arg = new ArrayList<>();
        switch (tree.toString()) {
            case "EXPR":
                arg.add(processEXPR(o));
                break;
            case "LIST":
                arg.add(processLIST(o));
                break;
            case "VARIABLE":
                arg.add(processVARIABLE(o));
                break;
            case "SYMBOL":
                arg.add(processSYMBOL(o));
                break;
            case "CONS":
                arg.add(processCONS(o));
                break;
            case "TL":
                arg.add(processTL(o));
                break;
            case "HD":
                arg.add(processHD(o));
                break;
            case "CALL":
                arg.addAll(processCALL(o));
                break;
            default:
                arg.add(processNIL(o));
                break;
        }
        return arg;
    }
private Registre processEXPR(Object o) {
    CommonTree tree = (CommonTree) o;
    Registre reg = new Registre();
    if(tree.getChildCount() == 2) {
        program.addLine(Line.Op.EQUALSINTER,
                reg,
                process(tree.getChild(0)).get(0),
                process(tree.getChild(1)).get(0));
    }
    else {
        program.addLine(Line.Op.ASSIGN, reg, process(tree.getChild(0)).get(0), new EmptyArgument());
    }
    return reg;
}
    private Registre processNIL(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        program.addLine(Line.Op.ASSIGN, reg, new Nil(), new EmptyArgument());
        return reg;
    }

    private Registre processVARIABLE(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        if (!tree.toString().equals("VARIABLE"))
            throw new RuntimeException("processVARIABLE called on non variable token");
        program.addLine(Line.Op.ASSIGN, reg, new Variable(tree.getChild(0).toString()), new EmptyArgument());
        return reg;
    }

    private Registre processSYMBOL(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        if (!tree.toString().equals("SYMBOL")) throw new RuntimeException("processSYMBOL called on non symbol token");
        program.addLine(Line.Op.ASSIGN, reg, new Symbol(tree.getChild(0).toString()), new EmptyArgument());
        return reg;
    }

    private Registre processTL(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre regTL = new Registre();
        program.addLine(Line.Op.TL, regTL, process(tree.getChild(0)).get(0), new EmptyArgument());
        return regTL;
    }

    private Registre processHD(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre regHD = new Registre();
        program.addLine(Line.Op.HD, regHD, process(tree.getChild(0)).get(0), new EmptyArgument());
        return regHD;
    }

    private Registre processCONS(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre regRes = new Registre();
        int childCount = tree.getChildCount();

        if(tree.getChild(0).getText().equals("VIDE")) {
                program.addLine(Line.Op.ASSIGN, regRes, new Nil(), new EmptyArgument());
        }
        else {
            List<Registre> processRes = new ArrayList<>();
            for (int i = 0; i < tree.getChildCount(); i++) {
                Object child = tree.getChild(i);
                List<Registre> vars = process(child);
                processRes.addAll(vars);
            }
            if( processRes.size() == 1) {
                program.addLine(Line.Op.ASSIGN, regRes, processRes.get(0), new EmptyArgument());
            }
            else {
                program.addLine(Line.Op.ASSIGN, regRes, processCONCAT(processRes, false), new EmptyArgument());
            }
        }
        return regRes;
    }

    private Registre processLIST(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre regList;
        int outCount = tree.getChildCount();
        List<Registre> vars = new ArrayList<>();
        for (int i = 0; i < outCount; i++) {
            Object child = tree.getChild(i);
            List<Argument> res = new ArrayList<>(process(child));
            for (Argument re : res) {
                Registre var = new Registre();
                program.addLine(Line.Op.ASSIGN, var, re, new EmptyArgument());
                vars.add(var);
            }
        }
        if (tree.toString().equals("LIST")) regList = processCONCAT(vars, true);
        else regList = processCONCAT(vars, false);
        return regList;
    }

    private Registre processCONCAT(List<Registre> vars, boolean isList) {
        Registre regList = new Registre();
        if (isList) {
            Registre nil = new Registre();
            program.addLine(Line.Op.ASSIGN, nil, new Nil(), new EmptyArgument());
            vars.add(nil);
        }

        int varCount = vars.size();
        if (varCount > 1) {
            Registre actual = vars.get(varCount - 1);

            for (int i = varCount - 1; i > 0; i--) {
                Registre cons = new Registre();
                program.addLine(Line.Op.CONS, cons, vars.get(i - 1), actual);
                actual = cons;
            }
            regList = actual;
        } else if (varCount == 1) {
            program.addLine(Line.Op.CONS, regList, vars.get(0), new Nil());
        } else {
            program.addLine(Line.Op.CONS, regList, new Nil(), new Nil());
        }
        return regList;
    }

    private List<Registre> processCALL(Object o) {
        CommonTree tree = (CommonTree) o;
        Symbol funcName = new Symbol(tree.getChild(0).toString());
        program.addLine(Line.Op.CALL, funcName);
        for (int i = 1; i < tree.getChildCount(); i++) {
            Object child = tree.getChild(i);
            if(child.toString().equals("VIDE")) {
                continue;
            }
            List<Registre> arg = new ArrayList<>(process(child));
            for (Argument argument : arg) {
                program.addLine(Line.Op.PARAMSET, argument);
            }
        }
        int outCount = functionOutputs.get(funcName.toString());
        List<Registre> outRegs = new ArrayList<>();
        for (int i = 0; i < outCount; i++) {
            Registre outReg = new Registre();
            outRegs.add(outReg);
            program.addLine(Line.Op.OUTPUTSET, outReg);
        }
        program.addLine(Line.Op.CALLEND, funcName);
        return outRegs;
    }

    private void processASSIGN(Object o) {
        CommonTree tree = (CommonTree) o;
        CommonTree ass_var = (CommonTree) tree.getChild(0);
        CommonTree ass_exp = (CommonTree) tree.getChild(1);
        for (int i = 0; i < ass_exp.getChildCount(); i++) {
            Object ass_var_child = ass_var.getChild(i);
            Object ass_exp_child = ass_exp.getChild(i);

            List<Registre> out = process(ass_exp_child);
            for (int j = 0; j < out.size(); j++) {
                program.addLine(
                        Line.Op.ASSIGN,
                        new Variable(ass_var_child.toString()),
                        out.get(j),
                        new EmptyArgument()
                );
            }
        }
    }

    public Program getProgram() {
        return program;
    }
}
