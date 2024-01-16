package Optimization;

import ThreeAddr.Argument;
import ThreeAddr.EmptyArgument;
import ThreeAddr.Line;
import ThreeAddr.Text;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private List<Line> lines = new ArrayList<>();
    private List<Block> parents = new ArrayList<>();
    public List<Argument> inputs = new ArrayList<>();
    public List<Argument> outputs = new ArrayList<>();

    public void optimizeBloc(){
        System.out.println("================ OPT Start ====================");
        System.out.println(("BLOCK BEFORE OPTI : ---------------------------"));
        printBlock();
        int modifs = 1;
        int nbrIter = 1;
        boolean broken = false;
        while(modifs > 0) {
            System.out.println("modifs = " + modifs);
            modifs = elimExpr();
            modifs += propagCopies();
            //int modifs_alive = elimDeadCode();
            int modifs_alive = 0;
            modifs += modifs_alive;

            while(modifs_alive > 0 ) {
                System.out.println("modifs_alive = " + modifs_alive);
                modifs_alive = elimDeadCode();
                nbrIter ++;
                if(nbrIter == 50) {
                    broken = true;
                    break;
                }
            }
            nbrIter++;
            if(nbrIter == 50) {
                broken = true;
                break;
            }

        }
        System.out.println(("BLOCK AFTER OPTI : ---------------------------"));
        System.out.println("BLOCK BROKEN : "+ broken);
        printBlock();
        updateOutputs();
        System.out.println("OPT END");

    }


    private void updateInputs() {
        inputs = new ArrayList<>();
        for(Block b : parents) {
            inputs.addAll(b.outputs);
        }
        //Evite d'avoir des doublons d'Argument d'entrée
        List<Argument> cleanInputs = new ArrayList<>();
        for(Argument i : inputs) {
            if (!cleanInputs.contains(i)) {
                cleanInputs.add(i);
            }
        }
        inputs = cleanInputs;
    }
    private void updateOutputs(){
        //Cherche dans les lignes toutes les variables recevant une expression.
        outputs = new ArrayList<>();
        for(Line line : lines) {
            String nameRes = line.op.toString();
            if((nameRes.equals("ASSIGN") || nameRes.equals("CONS")) && !outputs.contains(line.res)) {
                outputs.add(line.res);
            }
        }
    }
    private List<List<Line>> exprDisp() {
        List<List<Line>> exprs = new ArrayList<>();
        exprs.add(new ArrayList<>());
        if(!lines.isEmpty()) {
            List<Line> expr = new ArrayList<>();
            expr.add(lines.get(0));
            exprs.add(expr);
        }
        for(int i = 1; i < lines.size(); i ++) {
            List<Line> expr = exprs.get(exprs.size() - 1);
            expr.add(lines.get(i));
            exprs.add(expr);
        }
        return exprs;
    }

    private List<List<Argument>> aliveVar() {
        List<List<Argument>> vars = new ArrayList<>();
        updateOutputs();
        vars.add(outputs);
        for(int i = lines.size() - 1; i >= 0; i --) {
            Line line = lines.get(i);
            List<Argument> alive = vars.get(0);
            String nameRes = line.op.toString();
            if(nameRes.equals("ASSIGN")) {
                if(!alive.contains(line.arg1)) {
                    alive.add(line.arg1);
                }
                alive.remove(line.res);
            }
            else if( nameRes.equals("CONS")) {
                if(!alive.contains(line.arg1)) {
                    alive.add(line.arg1);
                }
                if(!alive.contains(line.arg2)) {
                    alive.add(line.arg2);
                }
                alive.remove(line.res);
            }
            vars.add(0, alive);
        }
        return vars;
    }
    private int elimExpr() {
        int modifs= 0;
        List<List<Line>> exprs = exprDisp();
        for(int i = 1; i < lines.size(); i ++) {
            String op = lines.get(i).op.toString();
            if(!(op.equals("ASSIGN") || op.equals("CONS"))) {
                continue;
            }
            for(Line line : exprs.get(i)) {
                if(line.compareArgs(lines.get(i))) {
                    lines.get(i).arg1 = line.res;
                    lines.get(i).arg2 = new EmptyArgument();
                    modifs ++;
                }
            }
        }
        //TODO
        return modifs;
    }
    private int propagCopies() {
        int modifs= 0;
        List<List<Line>> exprs = exprDisp();
        for(int i = 0; i < lines.size(); i ++) {
            String op = lines.get(i).op.toString();
            if(!(op.equals("ASSIGN") || op.equals("CONS"))) {
                continue;
            }
            for(Line line : exprs.get(i)) {
                if(line.op.toString().equals("CONS")) continue;
                if(line.res.toString().equals(lines.get(i).arg1.toString())) {
                    lines.get(i).arg1 = line.arg1;
                    modifs++;
                }if(line.res.toString().equals(lines.get(i).arg2.toString())) {
                    lines.get(i).arg2 = line.arg1;
                    modifs++;
                }
            }
        }
        return modifs;
    }
    private int elimDeadCode() {
        int modifs= 0;
        List<List<Argument>> vars = aliveVar();
        for(int i = 0; i < lines.size(); i ++ ) {
            boolean eliminate = true;
            for(Argument arg : vars.get(i + 1)) {
                if(arg.toString().equals(lines.get(i).res.toString())) {
                    eliminate = false;
                }
            }
            if(eliminate) {
                lines.get(i).res = new Text("_eliminate");
                modifs ++;
            }
        }
        int i = 0;
        while(i < lines.size()) {
            if(lines.get(i).res.toString().equals("_eliminate")) {
                lines.remove(lines.get(i));
            }
            else {
                i++;
            }
        }
        return modifs;
    }

    public void addParent(List<Block> b) {
        parents.addAll(b);
        updateInputs();
    }
    public void addLine(Line l) {
        lines.add(l);
    }
    public List<Line> getLines() {
        return lines;
    }
    public void printBlock () {

        for(Line line : lines ) {
            System.out.println(line.toString());
        }
    }
}
