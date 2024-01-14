package Optimization;

import SymbolTable.SymbolTable;
import SymbolTable.STEntry;
import SymbolTable.STFunc;

import ThreeAddr.Line;
import ThreeAddr.Program;
import ThreeAddr.Variable;

import java.util.ArrayList;
import java.util.List;

public class WhileOptimizator {

    private Program program;
    private SymbolTable symbolTable;
    private List<Block> blocks;

    WhileOptimizator(Program p, SymbolTable s) {
        this.program = p;
        this.symbolTable = s;
        createBlocks();
    }

    private void createBlocks() {
        //TODO


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
                case FORBEGIN, WHILEBEGIN, FOREACHBEGIN, IFBEGIN, ELSEBEGIN:
                    block.lines.add(line);
                    block.optimizeBloc();
                    blocks.add(block);
                    blocksAbove.add(block);
                    block = new Block();
                    block.setParent(blocksAbove.get(blocksAbove.size() - 1));
                    break;

                case WHILEEND, FOREACHEND, IFEND, ELSEEND:
                    block.lines.add(line);
                    block.optimizeBloc();
                    blocks.add(block);
                    blocksAbove.remove(blocksAbove.size() - 1);
                    block = new Block();
                    block.setParent(blocksAbove.get(blocksAbove.size() - 1));

                    break;
                case FOREND:
                    block.lines.add(line);
                    block.optimizeBloc();
                    blocks.add(block);
                    block = new Block();
                    block.setParent(blocksAbove.get(blocksAbove.size() - 1));
                    break;
                default:
                    block.lines.add(line);

            }
        }
    }

    public void optimizeLoc() {
        for(Block block : blocks) {
            block.optimizeBloc();
        }
    }
    public void optimizeGlob() {
        //TODO
    }
}