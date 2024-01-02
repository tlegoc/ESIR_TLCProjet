import SymbolTable.*;
import ThreeAddr.Line;
import ThreeAddr.Program;
import ThreeAddr.Registre;
import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    private Program program;
    private SymbolTable symbolTable;
    private String mainFunc;
    private int indent = 0;
    private int index_for = 0;

    public Convert(Program program, SymbolTable st, String mf) {
        this.program = program;
        this.symbolTable = st;
        this.mainFunc = mf;
    }

    private void addVariableForScope(StringBuilder res, int currentScope) {
        List<STEntry> symbols = symbolTable.getEntriesForScope(currentScope);

        for (STEntry s : symbols) {
            res.append("std::shared_ptr<Node> ").append(s.getSymbol()).append(" = std::make_shared<Node>();\n");
        }
    }

    public String convert() {
        ArrayList<String> params = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        res.append("#include \"lib_while.h\"\n");
        int currentScope = 0;
        for (int i = 0; i < program.getLineCount(); i++) {
            Line actualLine = program.getLine(i);

            switch (actualLine.op) {
                case PARAM:
                    res.append("std::shared_ptr<Node> ").append(actualLine.res);
                    if (program.getLine(i + 1).op != Line.Op.PARAM) {
                        indent++;
                        res.append(" ) {\n");
                        res.append("\t".repeat(indent));
                        currentScope++;
                        addVariableForScope(res, currentScope);
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
                        // If no parameter
                        currentScope++;
                        addVariableForScope(res, currentScope);
                    }
                    // NOTE : Do not add function variables here, do it after PARAM!
                    break;
                case FUNCEND:
                    res.append("}\n");
                    res.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(res, currentScope);
                    break;
                case OUTPUT:
                    indent--;
                    res.append("return ").append(actualLine.res).append(";\n");
                    res.append("\t".repeat(indent));
                    break;
                case ASSIGN:
                    if (actualLine.res instanceof Registre) {
                        res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    }
                    // Fix for assigning to nil
                    if (actualLine.arg1.toString().equals("nil")) {
                        res.append("Nil(").append(actualLine.res).append(");\n");
                        res.append("\t".repeat(indent));
                    } else {
                        res.append(actualLine.res).append(" = ").append(actualLine.arg1).append(";\n");
                        res.append("\t".repeat(indent));
                    }
                    break;
                case IFBEGIN:
                    indent++;
                    res.append("if (toBool(").append(actualLine.res).append(")) {\n");
                    res.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(res, currentScope);
                    break;
                case ELSEBEGIN:
                    indent++;
                    res.append("\nelse {\n");
                    res.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(res, currentScope);
                    break;
                case ELSEEND, WHILEEND, IFEND:
                    indent--;
                    res.append("}\n");
                    res.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(res, currentScope);
                    break;
                case WHILEBEGIN:
                    indent++;
                    res.append("while (").append("toBool(").append(actualLine.res).append(")) {\n");
                    res.append("\t".repeat(indent));

                    currentScope++;
                    addVariableForScope(res, currentScope);
                    break;
                case FORBEGIN:
                    indent++;
                    res.append("for (int _ID_for_").append(index_for).append(" = 0; _ID_for_").append(index_for).append("<= toInt(").append(actualLine.res).append("); _ID_for_").append(index_for).append("++ ) {\n");
                    res.append("\t".repeat(indent));
                    index_for++;
                    currentScope++;
                    addVariableForScope(res, currentScope);
                    break;
                case FOREND:
                    indent--;
                    index_for--;
                    res.append("}\n");
                    res.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(res, currentScope);
                    break;
                case CALL:
                    if (actualLine.res instanceof Registre) {
                        res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    }
                    res.append(actualLine.res).append(" = ").append(actualLine.arg1).append("(");
                    for (int param = 0; param < params.size(); param++) {
                        res.append(params.get(param));
                        if (param == params.size() - 1) {
                            continue;
                        }
                        res.append(", ");
                    }
                    res.append("); \n");
                    res.append("\t".repeat(indent));
                    params = new ArrayList<>();
                    break;
                case CONS:
                    if (actualLine.res instanceof Registre) {
                        res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    }
                    res.append("\t".repeat(indent));
                    res.append("Cons(").append(actualLine.res);
                    if (!actualLine.arg1.toString().equals("EMPTY")) {
                        if (actualLine.arg1.toString().equals("nil"))
                            res.append(", Nil()");
                        else
                            res.append(", ").append(actualLine.arg1);
                        if (!actualLine.arg2.toString().equals("EMPTY")) {

                            if (actualLine.arg2.toString().equals("nil"))
                                res.append(", Nil()");
                            else
                                res.append(", ").append(actualLine.arg2);
                        }
                    }
                    res.append(");\n").append("\t".repeat(indent));
                    break;
                case TL:
                    if (actualLine.res instanceof Registre) {
                        res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    }
                    res.append("\t".repeat(indent));
                    res.append("tl(").append(actualLine.res).append(", ").append(actualLine.arg1).append(");\n");
                    res.append("\t".repeat(indent));
                    break;
                case HD:
                    if (actualLine.res instanceof Registre) {
                        res.append("std::shared_ptr<Node> ").append(actualLine.res).append(" = std::make_shared<Node>();\n");
                    }
                    res.append("\t".repeat(indent));
                    res.append("hd(").append(actualLine.res).append(", ").append(actualLine.arg1).append(");\n");
                    res.append("\t".repeat(indent));
                    break;
                case IGNORE:
                default:
                    break;
            }
        }

        res.append("int main() { ");
        res.append(mainFunc).append("();");
        res.append("return 0; }");

        return res.toString();
    }


}
