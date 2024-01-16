package Optimization;

import SymbolTable.SymbolTable;
import SymbolTable.STEntry;
import SymbolTable.STFunc;

import ThreeAddr.Line;
import ThreeAddr.Program;
import ThreeAddr.Variable;

import java.util.ArrayList;
import java.util.List;

public class WhileOptimizer {

    private Program program;
    private SymbolTable symbolTable;
    private List<Block> blocks = new ArrayList<>();

    public WhileOptimizer(Program p, SymbolTable s) {
        this.program = p;
        this.symbolTable = s;
        createBlocks();
    }

    private void createBlocks() {
        List<Block> blocksAbove = new ArrayList<>();
        Block block = new Block();
        for(Line line : program.lines) {
            switch (line.op) {
                case FUNCBEGIN :
                    for(STEntry symbol : symbolTable.symbols) {
                        if (symbol instanceof STFunc func && func.name.equals( line.res.toString()))
                        {
                            block = new Block();
                            for(String input : func.parameters){
                                block.inputs.add(new Variable(input));
                                block.outputs.add(new Variable(input));
                            }
                            for(String output : func.outputs) {
                                block.outputs.add(new Variable(output));
                            }
                        }
                    }
                    blocksAbove.add(block);
                    break;

                case FUNCEND:
                    block.optimizeBloc();
                    blocks.add(block);
                    blocksAbove.remove(blocksAbove.size() - 1);
                    break;
                    //anciennement FORBEGIN, WHILEBEGIN, etc...
                case BLOCK:
                    block.addLine(line);
                    block.optimizeBloc();
                    blocks.add(block);
                    blocksAbove.add(block);
                    block = new Block();
                    block.addParent(blocksAbove);
                    break;
                //anciennement WHILEEND, etc...

                case JEQUALS:
                    block.addLine(line);
                    block.optimizeBloc();
                    blocks.add(block);
                    blocksAbove.remove(blocksAbove.size() - 1);
                    block = new Block();
                    block.addParent(blocksAbove);
                    break;
                //Anciennement FOREND
                case JGREATER:
                    block.addLine(line);
                    block.optimizeBloc();
                    blocks.add(block);
                    block = new Block();
                    block.addParent(blocksAbove);
                    break;
                case CALL, IGNORE:
                    break;
                default:
                    block.addLine(line);

            }
        }
    }

    private void optimizeLoc() {
        int i = 0;
        for(Block block : blocks) {
            System.out.println("Optimizing bloc " + i + "out of " + blocks.size());
            block.optimizeBloc();
        }
    }
    private void optimizeGlob() {
        //TODO
    }

    public Program optimize() {
        optimizeLoc();
        optimizeGlob();

        return blocksIntoProgram();
    }
    private Program blocksIntoProgram() {
        Program optiProg = new Program();
        for(Block block : blocks) {
            for(Line line : block.getLines()) {
                optiProg.addLine(line);
            }
        }
        return optiProg;
    }
    public String toString() {
        String result = "";
        //TODO
        return result;
    }
}