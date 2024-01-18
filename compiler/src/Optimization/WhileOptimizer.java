package Optimization;

import SymbolTable.SymbolTable;
import SymbolTable.STEntry;
import SymbolTable.STFunc;

import ThreeAddr.Line;
import ThreeAddr.Program;
import ThreeAddr.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WhileOptimizer {

    private Program program;
    private SymbolTable symbolTable;
   //private List<Block> blocks = new ArrayList<>();
    private final HashMap<String, Block> blocks = new HashMap<>();
    private final List<String[]> links = new ArrayList<>();
    public WhileOptimizer(Program p, SymbolTable s) {
        this.program = p;
        this.symbolTable = s;
        createBlocks();
    }

    private void createBlocks() {
        STFunc func_ = new STFunc(" ", new String[] {}, new String[] {});
        Block block = new Block();
        Block parent;
        String currentFunc = "";
        String oldBlockName = "";
        String blockName = "";
        for(Line line : program.lines) {
            switch (line.op) {
                case FUNCBEGIN :
                    for(STEntry symbol : symbolTable.symbols) {
                        if (symbol instanceof STFunc func && func.name.equals( line.res.toString()))
                        {
                            func_ = func;
                            blockName = func.name;
                            block = new Block();
                            currentFunc = blockName;

                            /*
                            for(String input : func.parameters){
                                block.outputs.add(new Variable(input));
                            }
                            */
                        }
                    }
                    blocks.put(blockName, block);
                    oldBlockName = blockName;
                    blockName += "_begin";
                    block = new Block();
                    //parent = block;
                    //block.addParent(parent);
                    break;

                case FUNCEND:
                    //block.optimizeBloc();
                    //On met le bloc courant dans la liste de block
                    blocks.put(blockName, block);

                    //on set le name du block parent
                    oldBlockName = blockName;
                    block = new Block();
                    blockName = line.res.toString() + "_end";
                    block.addLine(line);
                    //On set les param de sortie
                    for(int i = 0; i < func_.outputs.length; i ++) {
                        block.outputs.add(new Variable(func_.outputs[i]));
                    }
                    //on ajoute le block dans la liste de block e
                    blocks.put(blockName, block);
                    //create link between old and new block
                    links.add(new String[]{oldBlockName, blockName});
                    break;
                case BLOCK:
                    //block.optimizeBloc();
                    //set old block in list of blocks
                    blocks.put(blockName, block);
                    oldBlockName = blockName;
                    blockName = line.res.toString();
                    //set links between old and new block
                    links.add(new String[]{oldBlockName, blockName});
                    block = new Block();
                    block.addLine(line);
                    break;
                    /*
                case BLOCKEND:
                    block.optimizeBloc();
                    blocks.put(blockName, block);
                    blockName = line.res.toString()+"_end";
                    block = new Block();
                    block.addLine(line);
                    break;

                     */
                case JEQUALS, JGREATER:
                    block.addLine(line);
                    block.optimizeBloc();
                    blocks.put(blockName, block);
                    links.add(new String[]{blockName, line.res.toString()});
                    blockName  = line.res.toString();
                    block = new Block();
                    break;
                default:
                    block.addLine(line);
            }
        }
    }

    private void optimizeLoc() {
        int i = 0;
       //TODO
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
        Set<String> names = blocks.keySet();
        Program optiProg = new Program();
        for(String name : names) {
            Block block = blocks.get(name);
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