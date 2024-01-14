import SymbolTable.*;
import ThreeAddr.Line;
import ThreeAddr.Program;
import ThreeAddr.Registre;
import ThreeAddr.Symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPPConverter {

    private static final String[] cpp_keywords = new String[]
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
    private final Program program;
    private final SymbolTable symbolTable;
    private final String mainFunc;
    private int index_for = 0;
    private int index_foreach = 0;

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

        res.append("// Scope ").append(currentScope).append("\n//");
        for (STEntry s : symbols) {
            res.append(sanitizeSymbol(s.getSymbol())).append(" ");
        }
        res.append("\n");

        for (STEntry s : symbols) {
            res.append("NODE ").append(sanitizeSymbol(s.getSymbol())).append(" = MSNIL();\n");
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
        generatedCode.append("using namespace std;\n");

        int currentScope = 0;
        int equalsInter = 0;
        for (int i = 0; i < program.getLineCount(); i++) {
            Line line = program.getLine(i);
            String result = sanitizeSymbol(line.res.toString());
            String arg1 = sanitizeSymbol(line.arg1.toString());
            String arg2 = sanitizeSymbol(line.arg2.toString());

            // Vive les switchs
            switch (line.op) {
                case IGNORE:
                    generatedCode.append("//").append(line.res.toString()).append("\n");
                    break;
                case FUNCBEGIN:
                    generatedCode.append("void ").append(result).append("(");

                    STFunc func = symbolTable.getFunc(line.res.toString());

                    for (int j = 0; j < func.outputs.length; j++) {
                        generatedCode.append("NODE &").append(sanitizeSymbol(func.outputs[j]));
                        if (j < func.outputs.length - 1) generatedCode.append(", ");
                    }
                    for (int j = 0; j < func.parameters.length; j++) {
                        generatedCode.append(", ");
                        generatedCode.append("NODE ").append(sanitizeSymbol(func.parameters[j]));
                    }
                    generatedCode.append(" ) {\n");
                    // Les fonctions ont un scope de 2
                    currentScope+=2;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FUNCEND:
                    generatedCode.append("}\n");
                    // Les fonctions ont un scope de 2
                    currentScope+=2;
                    addVariableForScope(generatedCode, currentScope);
                    break;
//                case OUTPUT:
//                    generatedCode.append("return ").append(result).append(";\n");
//                    break;
                case ASSIGN:
                    if (line.res instanceof Registre) {
                        generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                    }
                    if (line.arg1.toString().equals("Nil")) {
                        generatedCode.append("Nil(").append(result).append(");\n");
                    }
                    else if (line.arg1 instanceof Symbol) {
                        generatedCode.append("Symbol(").append(result).append(", \"").append(line.arg1.toString()).append("\");\n");
                    } else {
                        generatedCode.append(result).append(" = ").append(arg1).append(";\n");
                    }
                    break;
                case IFBEGIN:
                    generatedCode.append("if (toBool(").append(result).append(")) {\n");
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case ELSEBEGIN:
                    generatedCode.append("\nelse {\n");
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case ELSEEND, WHILEEND, IFEND:
                    generatedCode.append("}\n");
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case WHILEBEGIN:
                    generatedCode.append("while (").append("toBool(").append(result).append(")) {\n");
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FORBEGIN:

                    generatedCode.append("for (int _for_").append(index_for).append(" = 0; _for_").append(index_for).append("<= toInt(").append(result).append("); _for_").append(index_for).append("++ ) {\n");
                    index_for++;
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FOREND:

                    index_for--;
                    generatedCode.append("}\n");
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FOREACHBEGIN:
                    String nameb = "_foreach_" + index_foreach;
                    index_foreach++;
                    generatedCode.append("NODE ").append(nameb).append(" = MSNIL();\n");
                    generatedCode.append(nameb).append(" = ").append(arg1).append(";\n");
                    generatedCode.append("while (").append("toBool(").append(nameb).append(")) {\n");
                    generatedCode.append("hd(").append(result).append(",").append(nameb).append(");\n");
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FOREACHEND:
                    index_foreach --;
                    String namee = "_foreach_" + index_foreach;
                    String nametmp = "_tmp" + namee;
                    generatedCode.append("NODE ").append(nametmp).append(" = MSNIL();\n");

                    generatedCode.append("tl(").append(nametmp).append(", ").append(namee).append(");\n");
                    generatedCode.append(namee).append(" = ").append(nametmp).append(";\n");
                    generatedCode.append("}\n");
                    currentScope++;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case CALLEND:
                    STFunc st_func = symbolTable.getFunc(line.res.toString());

                    generatedCode.append(result).append("(");
                    int nbrParams = st_func.parameters.length;
                    while(!assigns.isEmpty()) {
                        if (assigns.size() == 1) {
                            generatedCode.append(sanitizeSymbol(assigns.remove(0)));
                        } else {
                            generatedCode.append(sanitizeSymbol(assigns.remove(0))).append(", ");
                        }
                    }
                    if(nbrParams > 0) {
                        generatedCode.append(",");
                    }

                    while(!params.isEmpty()) {
                        if (params.size() == 1) {
                            generatedCode.append(sanitizeSymbol(params.remove(0)));
                        } else {
                            generatedCode.append(sanitizeSymbol(params.remove(0))).append(", ");
                        }
                    }
                    generatedCode.append(");\n");
                    break;
                case PARAMSET:
                    params.add(result);
                    break;
                case OUTPUTSET:
                    generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                    assigns.add(result);
                    break;
                case CONS:
                    if (line.res instanceof Registre) {
                        generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                    }
                    generatedCode.append("Cons(").append(result);
                    if (!line.arg1.toString().equals("EMPTY")) {
                        if (line.arg1.toString().equals("Nil"))
                            generatedCode.append(", Nil()");
                        else
                            generatedCode.append(", ").append(arg1);
                        if (!line.arg2.toString().equals("EMPTY")) {
                            if (line.arg2.toString().equals("Nil"))
                                generatedCode.append(", Nil()");
                            else
                                generatedCode.append(", ").append(arg2);
                        }
                    }
                    generatedCode.append(");\n");
                    break;
                case EQUALSINTER:
                    generatedCode.append("NODE ").append(result).append(" = equals(");
                    generatedCode.append(arg1).append(", ").append(arg2).append(");\n");

                    break;
                case TL:
                    if (line.res instanceof Registre) {
                        generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                    }
                    generatedCode.append("tl(").append(result).append(", ").append(result).append(");\n");
                    break;
                case HD:
                    if (line.res instanceof Registre) {
                        generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                    }
                    generatedCode.append("hd(").append(result).append(", ").append(result).append(");\n");
                    break;
//                case IGNORE:
                default:
                    break;
            }
        }

        // Au cas ou on a pas de fonction s'appelant main.

        generatedCode.append("int main() { NODE node;\n");
        generatedCode.append(sanitizeSymbol(mainFunc)).append("(node); ppln(node);\n");
        generatedCode.append("return 0; \n}\n");

        return generatedCode.toString();
    }


}
