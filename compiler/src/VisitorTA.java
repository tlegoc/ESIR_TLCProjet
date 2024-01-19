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
    private final List<List<String>> knownArg = new ArrayList<>();
    private int block_ind = -1;

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
            /*
            case "CONS":
                //program.addLine(Line.Op.CONS, processCONS(o), new EmptyArgument(), new EmptyArgument());

                break;

             */
            case "ASSIGN":
                processASSIGN(o);
                break;
            case "FUNC":
                String funcName = String.valueOf(tree.getChild(0));
                int outCount = tree.getChild(1).getChild(2).getChildCount();
                int inCount = tree.getChild(1).getChild(0).getChildCount();

                functionOutputs.put(funcName, outCount);
                program.addLine(Line.Op.FUNCBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                knownArg.add(new ArrayList<>());
                for(int i = 0; i < outCount; i ++) {
                    addInKnown(tree.getChild(1).getChild(2).getChild(i).toString(), false);
                }
                for(int i = 0; i < inCount; i ++ ) {
                    addInKnown(tree.getChild(1).getChild(0).getChild(i).toString(), false);
                }
                visit(tree.getChild(1));
                program.addLine(Line.Op.FUNCEND, new Symbol(String.valueOf(tree.getChild(0))));
                knownArg.remove(knownArg.size() - 1);
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
                BlockName for_enter = new BlockName("for_enter_"+ ++block_ind);
                BlockName for_exit = new BlockName("for_exit_"+ block_ind);

                Registre cond_for = process(tree.getChild(0)).get(0);
                program.addLine(Line.Op.JEQUALS, for_exit, cond_for, new Nil());
                program.addLine(Line.Op.BLOCK, for_enter);
                program.addLine(Line.Op.SCOPEBEGIN, new EmptyArgument());
                knownArg.add(new ArrayList<>());
                visit(tree.getChild(1));
                Registre tmp = new Registre();
                program.addLine(Line.Op.INIT, tmp);
                program.addLine(Line.Op.TL, tmp, cond_for);
                program.addLine(Line.Op.ASSIGN, cond_for, tmp);
                program.addLine(Line.Op.JGREATER, for_enter, cond_for, new Nil());
                program.addLine(Line.Op.SCOPEEND, new EmptyArgument());
                knownArg.remove(knownArg.size() - 1);
                program.addLine(Line.Op.BLOCK, for_exit);
                break;
            case "FOREACH":
                BlockName foreach_enter = new BlockName("foreach_enter_"+ ++block_ind);
                BlockName foreach_exit = new BlockName("foreach_exit_"+ block_ind);

                String name = tree.getChild(0).getChild(0).toString();
                Registre cond_foreach = process(tree.getChild(1)).get(0);
                Variable var_foreach = new Variable(name);
                program.addLine(Line.Op.JEQUALS, foreach_exit, cond_foreach, new Nil());
                program.addLine(Line.Op.BLOCK, foreach_enter);
                program.addLine(Line.Op.SCOPEBEGIN, new EmptyArgument());
                knownArg.add(new ArrayList<>());
                program.addLine(Line.Op.INIT, new Text(var_foreach.toString()));
                program.addLine(Line.Op.HD, var_foreach, cond_foreach);
                visit(tree.getChild(2));
                Registre tmp_foreach = new Registre();
                program.addLine(Line.Op.INIT, tmp_foreach);
                program.addLine(Line.Op.TL, tmp_foreach, cond_foreach);
                program.addLine(Line.Op.ASSIGN, cond_foreach, tmp_foreach);
                program.addLine(Line.Op.JGREATER, foreach_enter, cond_foreach, new Nil());
                program.addLine(Line.Op.SCOPEEND, new EmptyArgument());
                knownArg.remove(knownArg.size() - 1);

                program.addLine(Line.Op.BLOCK,foreach_exit);

                break;
            case "LIST":
                program.addLine(Line.Op.ASSIGN, new Registre(), processLIST(o), new EmptyArgument());
                break;
            case "WHILE":
                BlockName while_enter = new BlockName("while_enter_"+ ++block_ind);
                BlockName while_exit = new BlockName("while_exit_"+ block_ind);

                Argument cond_while = process(tree.getChild(0)).get(0);
                //pas très beau mais un while ne peut prendre que une variable en indice sinon boucle infinie !
                String cond_while_name = tree.getChild(0).getChild(0).getChild(0).toString();
                program.addLine(Line.Op.JEQUALS, while_exit, new Variable(cond_while_name), new Nil());
                program.addLine(Line.Op.BLOCK, while_enter);
                program.addLine(Line.Op.SCOPEBEGIN, new EmptyArgument());
                knownArg.add(new ArrayList<>());

                visit(tree.getChild(1));

                program.addLine(Line.Op.JGREATER, while_enter,  new Variable(cond_while_name), new Nil());
                program.addLine(Line.Op.SCOPEEND, new EmptyArgument());
                knownArg.remove(knownArg.size() - 1);

                program.addLine(Line.Op.BLOCK,while_exit);

                break;
            case "IF":
                BlockName if_enter = new BlockName("if_enter_"+ ++block_ind);
                BlockName if_exit = new BlockName("if_exit_"+ block_ind);
                BlockName else_exit = new BlockName("else_exit_" + block_ind);
                if(tree.getChildCount() > 2 ) {
                    if_exit = new BlockName("else_enter_" + block_ind);
                }
                Argument cond_if = process(tree.getChild(0)).get(0);

                program.addLine(Line.Op.JEQUALS, if_exit , cond_if, new Nil());
                program.addLine(Line.Op.JGREATER, if_enter, cond_if, new Nil());

                program.addLine(Line.Op.BLOCK, if_enter);
                program.addLine(Line.Op.SCOPEBEGIN, new EmptyArgument());
                knownArg.add(new ArrayList<>());

                visit(tree.getChild(1));
                program.addLine(Line.Op.SCOPEEND, new EmptyArgument());
                knownArg.remove(knownArg.size() - 1);

                program.addLine(Line.Op.BLOCK, if_exit);
                if (tree.getChildCount() > 2) {
                    program.addLine(Line.Op.SCOPEBEGIN, new EmptyArgument());
                    knownArg.add(new ArrayList<>());

                    visit(tree.getChild(2));
                    program.addLine(Line.Op.SCOPEEND, new EmptyArgument());
                    knownArg.remove(knownArg.size() - 1);

                    program.addLine(Line.Op.BLOCK, else_exit);
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

    private List<Registre> process(Object o) {
        CommonTree tree = (CommonTree) o;
        List<Registre> arg = new ArrayList<>();
        switch (tree.toString()) {
            case "EXPR":
                arg.addAll(processEXPR(o));
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
                arg.add(processNIL());
                break;
        }
        return arg;
    }

    private List<Registre> processEXPR(Object o) {
        CommonTree tree = (CommonTree) o;
        List<Registre> regs = new ArrayList<>();
        if (tree.getChildCount() == 2) {
            Registre reg =  new Registre();
            regs.add(reg);

            addInKnown(reg.toString(), true);
            program.addLine(Line.Op.EQUALSINTER,
                    reg,
                    process(tree.getChild(0)).get(0),
                    process(tree.getChild(1)).get(0));
        } else {
            regs.addAll(process(tree.getChild(0)));
        }
        return regs;
    }

    private Registre processNIL() {
        Registre reg = new Registre();
        addInKnown(reg.toString(), true);
        program.addLine(Line.Op.ASSIGN, reg, new Nil(), new EmptyArgument());
        return reg;
    }

    private Registre processVARIABLE(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        if (!tree.toString().equals("VARIABLE"))
            throw new RuntimeException("processVARIABLE called on non variable token");
        addInKnown(reg.toString(), true);
        program.addLine(Line.Op.ASSIGN, reg, new Variable(tree.getChild(0).toString()), new EmptyArgument());
        return reg;
    }

    private Registre processSYMBOL(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        if (!tree.toString().equals("SYMBOL")) throw new RuntimeException("processSYMBOL called on non symbol token");
        addInKnown(reg.toString(),true);
        program.addLine(Line.Op.ASSIGN, reg, new Symbol(tree.getChild(0).toString()), new EmptyArgument());
        return reg;
    }

    private Registre processTL(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        addInKnown(reg.toString(), true);
        program.addLine(Line.Op.TL, reg, process(tree.getChild(0)).get(0), new EmptyArgument());
        return reg;
    }

    private Registre processHD(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        addInKnown(reg.toString(), true);
        program.addLine(Line.Op.HD, reg, process(tree.getChild(0)).get(0), new EmptyArgument());
        return reg;
    }

    private Registre processCONS(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg = new Registre();
        addInKnown(reg.toString(), true);

        if (tree.getChild(0).getText().equals("VIDE")) {
            program.addLine(Line.Op.ASSIGN, reg, new Nil(), new EmptyArgument());
        } else {
            List<Registre> processRes = new ArrayList<>();
            for (int i = 0; i < tree.getChildCount(); i++) {
                Object child = tree.getChild(i);
                List<Registre> vars = process(child);
                processRes.addAll(vars);
            }
            if (processRes.size() == 1) {
                program.addLine(Line.Op.ASSIGN, reg, processRes.get(0), new EmptyArgument());
            } else {
                program.addLine(Line.Op.ASSIGN, reg, processCONCAT(processRes, false), new EmptyArgument());
            }
        }
        return reg;
    }

    private Registre processLIST(Object o) {
        CommonTree tree = (CommonTree) o;
        Registre reg;
        int outCount = tree.getChildCount();
        List<Registre> vars = new ArrayList<>();
        for (int i = 0; i < outCount; i++) {
            Object child = tree.getChild(i);
            List<Argument> res = new ArrayList<>(process(child));
            for (Argument arg : res) {
                Registre var = new Registre();
                addInKnown(var.toString(), true);
                program.addLine(Line.Op.ASSIGN, var, arg, new EmptyArgument());
                vars.add(var);
            }
        }
        if (tree.toString().equals("LIST")) reg = processCONCAT(vars, true);
        else reg = processCONCAT(vars, false);
        return reg;
    }

    private Registre processCONCAT(List<Registre> vars, boolean isList) {
        Registre reg = new Registre();
        if (isList) {
            Registre nil = new Registre();
            addInKnown(nil.toString(), true);
            program.addLine(Line.Op.ASSIGN, nil, new Nil(), new EmptyArgument());
            vars.add(nil);
        }

        int varCount = vars.size();
        if (varCount > 1) {
            Registre actual = vars.get(varCount - 1);

            for (int i = varCount - 1; i > 0; i--) {
                Registre cons = new Registre();
                addInKnown(cons.toString(), true);
                program.addLine(Line.Op.CONS, cons, vars.get(i - 1), actual);
                actual = cons;
            }
            reg = actual;
        } else if (varCount == 1) {
            addInKnown(reg.toString(), true);
            program.addLine(Line.Op.CONS, reg, vars.get(0), new Nil());
        } else {
            addInKnown(reg.toString(), true);
            program.addLine(Line.Op.CONS, reg, new Nil(), new Nil());
        }
        return reg;
    }

    private List<Registre> processCALL(Object o) {
        CommonTree tree = (CommonTree) o;
        Symbol funcName = new Symbol(tree.getChild(0).toString());
        for (int i = 1; i < tree.getChildCount(); i++) {
            Object child = tree.getChild(i);
            if (child.toString().equals("VIDE")) {
                continue;
            }
            List<Registre> arg = process(child);
            for (Argument argument : arg) {
                program.addLine(Line.Op.PARAMSET, argument);
            }
        }
        int outCount = functionOutputs.get(funcName.toString());
        List<Registre> outRegs = new ArrayList<>();
        for (int i = 0; i < outCount; i++) {
            Registre outReg = new Registre();
            outRegs.add(outReg);
            addInKnown(outReg.toString(),true);
            program.addLine(Line.Op.OUTPUTSET, outReg);
        }
        program.addLine(Line.Op.CALL, funcName);
        return outRegs;
    }

    private void processASSIGN(Object o) {
        CommonTree tree = (CommonTree) o;
        CommonTree ass_var = (CommonTree) tree.getChild(0);
        CommonTree ass_exp = (CommonTree) tree.getChild(1);
        int consumed = 0;
        for (int i = 0; i < ass_exp.getChildCount(); i++) {
            Object ass_exp_child = ass_exp.getChild(i);

            List<Registre> out = process(ass_exp_child);
            for (Registre registre : out) {
                addInKnown(ass_var.getChild(consumed).toString(),true);
                program.addLine(
                        Line.Op.ASSIGN,
                        new Variable(ass_var.getChild(consumed).toString()),
                        registre,
                        new EmptyArgument()
                );
                consumed++;
            }
        }
    }

    /*
    private List<String> knownArgToList() {
        List<String> res = new ArrayList<>();
        for(List<String> l : knownArg) {
            res.addAll(l);
        }
        return res;
    }

     */
    /*
    private <T extends Argument> void addInKnown(List<T> list) {
        if (knownArg.isEmpty()) return;
        for(T arg : list) {
            addInKnown(arg.toString());
        }
    }

     */
    private void addInKnown(String arg, boolean init) {
        if (knownArg.isEmpty()) return;
        boolean isIn = false;
        for(List<String> list : knownArg) {
            for(String knownVar : list) {
                if(arg.equals(knownVar)){
                    isIn = true;
                    break;
                }
            }
            if(isIn) break;
        }
        if(!isIn) {
            if(init) program.addLine(Line.Op.INIT, new Text(arg));
            knownArg.get(knownArg.size() - 1).add(arg);
            printKnownArg();
        }
    }

    private void printKnownArg() {
        StringBuilder res = new StringBuilder();
        for(List<String> list : knownArg) {
            res.append("[");
            for( String str : list ) {
                res.append(str).append(", ");
            }
            res.append("]---");
        }
        System.out.println(res);
    }

    public Program getProgram() {
        return program;
    }
}
