package Optimization;

import SymbolTable.SymbolTable;
import SymbolTable.STEntry;
import SymbolTable.STFunc;
import SymbolTable.STVariable;
import SymbolTable.STBlockStart;
import SymbolTable.STBlockEnd;

import ThreeAddr.Argument;
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
        List<Line> lines = new ArrayList<>();
        List<Argument> inputs = new ArrayList<>();
        List<Argument> outputs = new ArrayList<>();
        List<Block> blocksAbove = new ArrayList<>();
        String currentFunc = "";
        String[] funcOutputs = new String[0];
        Block block = new Block();
        for(Line line : program.lines) {
            switch (line.op) {
                case FUNCBEGIN :
                    currentFunc = line.res.toString();
                    for(STEntry symbol : symbolTable.symbols) {
                        if (symbol instanceof STFunc func && func.name.equals(currentFunc)) {
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
                    block.addParent(blocksAbove.get(blocksAbove.size() - 1));
                    break;
                case FOREND, WHILEEND, FOREACHEND, IFEND, ELSEEND:
                    block.optimizeBloc();
                    if(!block.lines.isEmpty()) {
                        blocks.add(block);
                    }
                    blocksAbove.remove(blocksAbove.size() - 1);
                    block = new Block();
                    block.addParent(blocksAbove.get(blocksAbove.size() - 1));

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