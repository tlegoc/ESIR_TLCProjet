package Optimization;

import ThreeAddr.Argument;
import ThreeAddr.Line;

import java.util.ArrayList;
import java.util.List;

public class Block {
    public List<Line> lines;
    public List<Argument> inputs;
    public List<Argument> outputs;
    private List<Block> parents;
    public Block(List<Line> l, List<Block> p, List<Block> c) {
        this.lines = l;
        this.parents = p;
        updateInputs();
    }
    public Block() {
        this.lines = new ArrayList<>();
        this.parents = new ArrayList<>();
        updateInputs();
    }

    private void updateInputs() {
        inputs = new ArrayList<>();
        for(Block parent : parents) {
            inputs.addAll(parent.outputs);
        }
    }
    private void updateOutputs(){
        //TODO
        //Cherche dans les lignes restantes toutes les variables recevant une expression
    }
    private List<List<Line>> exprDisp() {
        List<List<Line>> exprs = new ArrayList<>();

        //TODO
        return exprs;
    }

    private List<List<Argument>> aliveVar() {
        List<List<Argument>> vars = new ArrayList<>();

        //TODO
        return vars;
    }
    private int elimExpr() {
        int modifs= 0;
        List<List<Line>> exprs = exprDisp();

        //TODO
        return modifs;
    }
    private int propagCopies() {
        int modifs= 0;
        List<List<Line>> exprs = exprDisp();

        //TODO
        return modifs;
    }
    private int elimDeadCode() {
        int modifs= 0;
        List<List<Argument>> vars = aliveVar();

        //TODO
        return modifs;
    }
    public void optimizeBloc(){
        int modifs = 1;
        while(modifs > 0) {
            modifs = elimExpr();
            modifs += propagCopies();
            modifs += elimDeadCode();
        }
        updateOutputs();
    }

    public void addParent(Block b) {
        parents.add(b);
        updateInputs();
    }
}
