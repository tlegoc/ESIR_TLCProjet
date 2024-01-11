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
                    "xor_eq",
                    "main", // Evite d'avoir deux fois une fonction main.
            };

    public CPPConverter(Program program, SymbolTable st, String mf) {
        this.program = program;
        this.symbolTable = st;
        this.mainFunc = mf;
    }

    /***
     * Rajoute la declaration de toutes les variables dans un
     * block donne
     * @param res le code cpp dans lequel on ajoute les variables
     * @param currentScope le block actuel
     */
    private void addVariableForScope(StringBuilder res, int currentScope) {
        List<STEntry> symbols = symbolTable.getEntriesForScope(currentScope);

        for (STEntry s : symbols) {
            res.append("std::shared_ptr<Node> ").append(sanitizeSymbol(s.getSymbol())).append(" = std::make_shared<Node>();\n");
        }
    }

    /***
     * Evite les caracteres qui peuvent casser g++
     * @param symbol le symbol a nettoyer
     * @return le symbole nettoye
     */
    public static String sanitizeSymbol(String symbol) {
        if (Arrays.stream(cpp_keywords).anyMatch(symbol::equals)) {
            return symbol + "_sanitized";
        }

        // Shit fix, to replace later
        return symbol.replace("!", "pointdexclamation").replace("?", "pointdinterrogation");
    }

    public String convert() {
        ArrayList<String> params = new ArrayList<>();
        ArrayList<String> assigns = new ArrayList<>();

        StringBuilder generatedCode = new StringBuilder();

        generatedCode.append("#include \"lib_while.h\"\n");

        int currentScope = 0;
        for (int i = 0; i < program.getLineCount(); i++) {
            Line actualLine = program.getLine(i);

            // Vive les switchs
            switch (actualLine.op) {

                case FUNCBEGIN:
                    generatedCode.append("void ").append(sanitizeSymbol(actualLine.res.toString())).append("(");

                    STFunc func = symbolTable.getFunc(actualLine.res.toString());

                    for (int j = 0; j < func.outputs.length; j++) {
                        generatedCode.append("std::shared_ptr<Node> &").append(sanitizeSymbol(func.outputs[j]));
                        if (j < func.outputs.length - 1) generatedCode.append(", ");
                    }
                    for (int j = 0; j < func.parameters.length; j++) {
                        generatedCode.append(", ");
                        generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(func.parameters[j]));
                    }
                    indent++;
                    generatedCode.append(" ) {\n");
                    generatedCode.append("\t".repeat(indent));
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
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
                    if (actualLine.arg1.toString().equals("nil")) {
                        generatedCode.append("Nil(").append(sanitizeSymbol(actualLine.res.toString())).append(");\n");
                    } else {
                        generatedCode.append(sanitizeSymbol(actualLine.res.toString())).append(" = ").append(sanitizeSymbol(actualLine.arg1.toString())).append(";\n");
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
                    STFunc st_func = symbolTable.getFunc(actualLine.res.toString());
                    int nbrAssigns = st_func.outputs.length;
                    int nbrParams = st_func.parameters.length;
                    generatedCode.append(actualLine.res.toString()).append("(");
                    for(int j = 0; j < nbrAssigns; j ++) {
                        if (j == nbrAssigns - 1) {
                            generatedCode.append(sanitizeSymbol(assigns.remove(0)));
                        } else {
                            generatedCode.append(sanitizeSymbol(assigns.remove(0))).append(", ");
                        }
                    }
                    if(nbrParams > 0) {
                        generatedCode.append(",");
                    }
                    for(int j = 0; j < nbrParams; j ++) {
                        if (j == nbrParams - 1) {

                            generatedCode.append(sanitizeSymbol(params.remove(0)));
                        } else {
                            generatedCode.append(sanitizeSymbol(params.remove(0))).append(", ");
                        }
                    }
                    generatedCode.append(")");
                    break;
                case PARAMSET:
                    params.add(sanitizeSymbol(actualLine.res.toString()));
                    break;
                case OUTPUTSET:
                    assigns.add(sanitizeSymbol(actualLine.res.toString()));
                    break;
                case CONS:
                    if (actualLine.res instanceof Registre) {
                        generatedCode.append("std::shared_ptr<Node> ").append(sanitizeSymbol(actualLine.res.toString())).append(" = std::make_shared<Node>();\n");
                    }
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
                    generatedCode.append(");\n");
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

        // Au cas ou on a pas de fonction s'appelant main.
        generatedCode.append("int main() { ");
        generatedCode.append(sanitizeSymbol(mainFunc)).append("();");
        generatedCode.append("return 0; }");

        return generatedCode.toString();
    }


}
