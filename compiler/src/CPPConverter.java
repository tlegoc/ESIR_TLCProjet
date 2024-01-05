import SymbolTable.*;
import ThreeAddr.Line;
import ThreeAddr.Program;
import ThreeAddr.Registre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPPConverter {

    private final Program program;
    private final SymbolTable symbolTable;
    private final String mainFunc;
    private int indent = 0;
    private int index_for = 0;

    private static String[] cpp_keywords = new String[]
    {
        "alignas",
        "alignof",
        "and",
        "and_eq",
        "asm",
        "atomic_cancel",
        "atomic_commit",
        "atomic_noexcept",
        "auto",
        "bitand",
        "bitor",
        "bool",
        "break",
        "case",
        "catch",
        "char",
        "char8_t ",
        "char16_t",
        "char32_t",
        "class ",
        "compl",
        "concept ",
        "const",
        "consteval",
        "constexpr",
        "constinit",
        "const_cast",
        "continue",
        "co_await ",
        "co_return",
        "co_yield  ",
        "decltype ",
        "default",
        "delete ",
        "do",
        "double",
        "dynamic_cast",
        "else",
        "enum",
        "explicit",
        "export",
        "extern",
        "false",
        "float",
        "for",
        "friend",
        "goto",
        "if",
        "inline",
        "int",
        "long",
        "mutable",
        "namespace",
        "new",
        "noexcept",
        "not",
        "not_eq",
        "nullptr",
        "operator",
        "or",
        "or_eq",
        "private",
        "protected",
        "public",
        "reflexpr",
        "register",
        "reinterpret_cast",
        "requires",
        "return",
        "short",
        "signed",
        "sizeof",
        "static",
        "static_assert",
        "static_cast",
        "struct",
        "switch",
        "synchronized",
        "template",
        "this",
        "thread_local",
        "throw",
        "true",
        "try",
        "typedef",
        "typeid",
        "typename",
        "union",
        "unsigned",
        "using",
        "virtual",
        "void",
        "volatile",
        "wchar_t",
        "while",
        "xor",
        "xor_eq"
    };

    public CPPConverter(Program program, SymbolTable st, String mf) {
        this.program = program;
        this.symbolTable = st;
        this.mainFunc = mf;
    }

    private void addVariableForScope(StringBuilder res, int currentScope) {
        List<STEntry> symbols = symbolTable.getEntriesForScope(currentScope);

        for (STEntry s : symbols) {
            res.append("std::shared_ptr<Node> ").append(sanitizeSymbol(s.getSymbol())).append(" = std::make_shared<Node>();\n");
        }
    }

    // Allows us to use keywords as function names
    public static String sanitizeSymbol(String symbol)
    {
        if (Arrays.stream(cpp_keywords).anyMatch(symbol::equals))
        {
            return symbol + "_sanitized";
        }
        return symbol;
    }

    public String convert() {
        ArrayList<String> params = new ArrayList<>();
        StringBuilder generatedCode = new StringBuilder();
        generatedCode.append("#include \"lib_while.h\"\n");
        int currentScope = 0;
        for (int i = 0; i < program.getLineCount(); i++) {
            Line actualLine = program.getLine(i);

            switch (actualLine.op) {
                case PARAM:
                    generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString()));
                    if (program.getLine(i + 1).op != Line.Op.PARAM) {
                        indent++;
                        generatedCode.append(" ) {\n");
                        generatedCode.append("\t".repeat(indent));
                        currentScope++;
                        addVariableForScope(generatedCode, currentScope);
                    } else {
                        generatedCode.append(", ");
                    }

                    break;
                case PARAMSET:
                    params.add(sanitizeSymbol(actualLine.res.toString()));
                    break;
                case FUNCBEGIN:
                    generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString())).append("(");
                    if (program.getLine(i + 1).op != Line.Op.PARAM) {
                        indent++;
                        generatedCode.append(" ) {\n");
                        generatedCode.append("\t".repeat(indent));
                        // If no parameter
                        currentScope++;
                        addVariableForScope(generatedCode, currentScope);
                    }
                    // NOTE : Do not add function variables here, do it after PARAM!
                    break;
                case FUNCEND:
                    generatedCode.append("}\n");
                    generatedCode.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case OUTPUT:
                    indent--;
                    generatedCode.append("return ").append(sanitizeSymbol(actualLine.res.toString())).append(";\n");
                    generatedCode.append("\t".repeat(indent));
                    break;
                case ASSIGN:
                    if (actualLine.res instanceof Registre) {
                        generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString())).append(" = std::make_shared<Node>();\n");
                    }
                    // Fix for assigning to nil
                    if (actualLine.arg1.toString().equals("nil")) {
                        generatedCode.append("Nil(").append(sanitizeSymbol(actualLine.res.toString())).append(");\n");
                        generatedCode.append("\t".repeat(indent));
                    } else {
                        generatedCode.append(sanitizeSymbol(actualLine.res.toString())).append(" = ").append(sanitizeSymbol(actualLine.arg1.toString())).append(";\n");
                        generatedCode.append("\t".repeat(indent));
                    }
                    break;
                case IFBEGIN:
                    indent++;
                    generatedCode.append("if (toBool(").append(sanitizeSymbol(actualLine.res.toString())).append(")) {\n");
                    generatedCode.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case ELSEBEGIN:
                    indent++;
                    generatedCode.append("\nelse {\n");
                    generatedCode.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case ELSEEND, WHILEEND, IFEND:
                    indent--;
                    generatedCode.append("}\n");
                    generatedCode.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case WHILEBEGIN:
                    indent++;
                    generatedCode.append("while (").append("toBool(").append(sanitizeSymbol(actualLine.res.toString())).append(")) {\n");
                    generatedCode.append("\t".repeat(indent));

                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FORBEGIN:
                    indent++;
                    generatedCode.append("for (int _ID_for_").append(index_for).append(" = 0; _ID_for_").append(index_for).append("<= toInt(").append(sanitizeSymbol(actualLine.res.toString())).append("); _ID_for_").append(index_for).append("++ ) {\n");
                    generatedCode.append("\t".repeat(indent));
                    index_for++;
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FOREND:
                    indent--;
                    index_for--;
                    generatedCode.append("}\n");
                    generatedCode.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case CALL:
                    if (actualLine.res instanceof Registre) {
                        generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString())).append(" = std::make_shared<Node>();\n");
                    }
                    generatedCode.append(sanitizeSymbol(actualLine.res.toString())).append(" = ").append(sanitizeSymbol(actualLine.arg1.toString())).append("(");
                    for (int param = 0; param < params.size(); param++) {
                        generatedCode.append(sanitizeSymbol(params.get(param)));
                        if (param == params.size() - 1) {
                            continue;
                        }
                        generatedCode.append(", ");
                    }
                    generatedCode.append("); \n");
                    generatedCode.append("\t".repeat(indent));
                    params = new ArrayList<>();
                    break;
                case CONS:
                    if (actualLine.res instanceof Registre) {
                        generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString())).append(" = std::make_shared<Node>();\n");
                    }
                    generatedCode.append("\t".repeat(indent));
                    generatedCode.append("Cons(").append(sanitizeSymbol(actualLine.res.toString()));
                    if (!actualLine.arg1.toString().equals("EMPTY")) {
                        if (actualLine.arg1.toString().equals("nil"))
                            generatedCode.append(", Nil()");
                        else
                            generatedCode.append(", ").append(sanitizeSymbol(actualLine.arg1.toString()));
                        if (!actualLine.arg2.toString().equals("EMPTY")) {

                            if (actualLine.arg2.toString().equals("nil"))
                                generatedCode.append(", Nil()");
                            else
                                generatedCode.append(", ").append(sanitizeSymbol(actualLine.arg2.toString()));
                        }
                    }
                    generatedCode.append(");\n").append("\t".repeat(indent));
                    break;
                case TL:
                    if (actualLine.res instanceof Registre) {
                        generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString())).append(" = std::make_shared<Node>();\n");
                    }
                    generatedCode.append("\t".repeat(indent));
                    generatedCode.append("tl(").append(sanitizeSymbol(actualLine.res.toString())).append(", ").append(sanitizeSymbol(actualLine.arg1.toString())).append(");\n");
                    generatedCode.append("\t".repeat(indent));
                    break;
                case HD:
                    if (actualLine.res instanceof Registre) {
                        generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString())).append(" = std::make_shared<Node>();\n");
                    }
                    generatedCode.append("\t".repeat(indent));
                    generatedCode.append("hd(").append(sanitizeSymbol(actualLine.res.toString())).append(", ").append(sanitizeSymbol(actualLine.arg1.toString())).append(");\n");
                    generatedCode.append("\t".repeat(indent));
                    break;
                case IGNORE:
                default:
                    break;
            }
        }

        generatedCode.append("int main() { ");
        generatedCode.append(sanitizeSymbol(mainFunc)).append("();");
        generatedCode.append("return 0; }");

        return generatedCode.toString();
    }


}
