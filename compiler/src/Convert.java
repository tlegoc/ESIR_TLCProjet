import ThreeAddr.Line;
import ThreeAddr.Program;
import org.stringtemplate.v4.ST;

import java.util.ArrayList;

public class Convert {

    private Program program;
    private int indent = 0;
    private int index_for = 0;
    public Convert(Program program){
        this.program = program;
    }

    public String convert() {
        ArrayList<String> params = new ArrayList<>();
        StringBuilder res = new StringBuilder();    
        res.append("#include \"lib_while.h\"\n");
        for (int i = 0; i < program.getLineCount(); i++) {
            Line actualLine = program.getLine(i);

            switch (actualLine.op) {
                case PARAM:
                    res.append("std::shared_ptr<Node> ").append(actualLine.res);
                    if (program.getLine(i + 1).op != Line.Op.PARAM) {
                        indent++;
                        res.append(" ) {\n");
                        res.append("\t".repeat(indent));
                    } else {
                        res.append(", ");
                    }
                    break;
                case PARAMSET:
                    params.add(actualLine.res.toString());
                    break;
                case FUNCBEGIN:
                    res.append("std::shared_ptr<Node> ").append(actualLine.res).append("(");
                    if (program.getLine(i + 1).op != Line.Op.PARAM) {
                        indent++;
                        res.append(" ) {\n");
                        res.append("\t".repeat(indent));
                    }
                    break;
                case FUNCEND:
                    res.append("}\n");
                    res.append("\t".repeat(indent));
                    break;
                case OUTPUT:
                    indent--;
                    res.append("return ").append(actualLine.res).append(";\n");
                    res.append("\t".repeat(indent));
                    break;
                case ASSIGN:
                    res.append(actualLine.res).append(" = ").append(actualLine.arg1).append(";\n");
                    res.append("\t".repeat(indent));
                    break;
                case IFBEGIN:
                    indent++;
                    res.append("if (toBool(").append(actualLine.res).append(")) {\n");
                    res.append("\t".repeat(indent));
                    break;
                case ELSEBEGIN:
                    indent++;
                    res.append("\nelse {\n");
                    res.append("\t".repeat(indent));
                    break;
                case ELSEEND, WHILEEND, IFEND:
                    indent--;
                    res.append("}\n");
                    res.append("\t".repeat(indent));
                    break;
                case WHILEBEGIN:
                    indent++;
                    res.append("while () {\n");
                    res.append("\t".repeat(indent));
                    break;
                case FORBEGIN:
                    indent++;
                    res.append("for (int _ID_for_").append(index_for).append(" = 0; _ID_for_").append(index_for).append("<= toInt(").append(actualLine.res).append("); _ID_for_").append(index_for).append("++ ) {\n");
                    res.append("\t".repeat(indent));
                    index_for++;
                    break;
                case FOREND:
                    indent--;
                    index_for--;
                    res.append("}\n");
                    res.append("\t".repeat(indent));
                    break;
                case CALL:
                    res.append(actualLine.res).append(" = ").append(actualLine.arg1).append("(");
                    for(int param = 0; param < params.size(); param ++) {
                        res.append(params.get(param));
                        if(param == params.size() - 1) {
                            continue;
                        }
                        res.append(", ");
                    }
                    res.append("); \n");
                    res.append("\t".repeat(indent));
                    params = new ArrayList<>();
                case IGNORE:
                case CONS:
                    res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    res.append("\t".repeat(indent));
                    res.append("Cons(").append(actualLine.res);
                    if(!actualLine.arg1.toString().equals("EMPTY")){
                        res.append(", ").append(actualLine.arg1);
                        if(!actualLine.arg2.toString().equals("EMPTY")){
                            res.append(", ").append(actualLine.arg2);
                        }
                    }
                    res.append(");\n").append("\t".repeat(indent));
                    break;
                case TL:
                    res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    res.append("\t".repeat(indent));
                    res.append("tl(").append(actualLine.res).append(", ").append(actualLine.arg1).append(");\n");
                    res.append("\t".repeat(indent));
                    break;
                case HD:
                    res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    res.append("\t".repeat(indent));
                    res.append("hd(").append(actualLine.res).append(", ").append(actualLine.arg1).append(");\n");
                    res.append("\t".repeat(indent));
                    break;
                default:
                    break;
            }
        }
        return res.toString();
    }


}
