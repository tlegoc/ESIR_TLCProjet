import SymbolTable.*;
import ThreeAddr.*;

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
    private int index_for = 0;
    private int index_foreach = 0;

    public CPPConverter(Program program, SymbolTable st) {
        this.program = program;
        this.symbolTable = st;
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
                    currentScope += 2;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case FUNCEND:

                    generatedCode.append("}\n");
                    // Les fonctions ont un scope de 2
                    currentScope += 2;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case ASSIGN:
                    if (line.res instanceof Registre reg) {
                        if (!reg.isInitialized) {
                            reg.isInitialized = true;
                            generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                        }
                    }
                    if (line.arg1.toString().equals("Nil")) {
                        generatedCode.append("Nil(").append(result).append(");\n");
                    }
                    else if (line.arg1 instanceof Symbol) {
                        generatedCode.append("Symbol(").append(result).append(", \"").append(line.arg1).append("\");\n");
                    } else {
                        generatedCode.append(result).append(" = ").append(arg1).append(";\n");
                    }
                    break;
                case BLOCK:
                    String blockName = line.res.toString();
                    generatedCode.append(blockName).append(" :\n");
                    generatedCode.append("{\n");
                    currentScope+=1;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case BLOCKEND:
                    generatedCode.append("}\n");
                    currentScope+=1;
                    addVariableForScope(generatedCode, currentScope);
                    break;
                case JEQUALS:
                    String destination_equ = line.res.toString();
                    String true_arg1 = arg1;
                    String true_arg2 = arg2;
                    if (arg2.equals("Nil")) true_arg2 = "Nil()";
                    if (arg1.equals("Nil")) true_arg1 = "Nil()";

                    generatedCode.append("if (toBool(equals(").append(true_arg1).append(", ").append(true_arg2).append("))) ");
                    generatedCode.append("goto ").append(destination_equ).append(";\n");
                    break;
                case JGREATER:
                    String arg1_gr = line.arg1.toString();
                    String arg2_gr = line.arg2.toString();
                    String destination_gr = line.res.toString();
                    if(arg1_gr.equals("Nil")) arg1_gr = "0";
                    else arg1_gr = "toInt("+line.arg1.toString()+")";
                    if(arg2_gr.equals("Nil")) arg2_gr = "0";
                    else arg2_gr = "toInt("+line.arg2.toString()+")";

                    generatedCode.append("if (").append(arg1_gr).append(" > ").append(arg2_gr).append(") ");
                    generatedCode.append("goto ").append(destination_gr).append(";\n");
                    break;
                case CALLEND:
                    STFunc st_func = symbolTable.getFunc(line.res.toString());

                    generatedCode.append(result).append("(");
                    int nbrParams = st_func.parameters.length;
                    while (!assigns.isEmpty()) {
                        if (assigns.size() == 1) {
                            generatedCode.append(sanitizeSymbol(assigns.remove(0)));
                        } else {
                            generatedCode.append(sanitizeSymbol(assigns.remove(0))).append(", ");
                        }
                    }
                    if (nbrParams > 0) {
                        generatedCode.append(",");
                    }

                    while (!params.isEmpty()) {
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
                    if (line.res instanceof Registre reg) {
                        if (!reg.isInitialized) {
                            reg.isInitialized = true;
                            generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                        }
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
                    // TODO ????
                    generatedCode.append("NODE ").append(result).append(" = equals(");
                    generatedCode.append(arg1).append(", ").append(arg2).append(");\n");

                    break;
                case TL:
                    if (line.res instanceof Registre reg) {
                        if (!reg.isInitialized) {
                            reg.isInitialized = true;
                            generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                        }
                    }
                    generatedCode.append("tl(").append(result).append(", ").append(arg1).append(");\n");
                    break;
                case HD:
                    if (line.res instanceof Registre reg) {
                        if (!reg.isInitialized) {
                            reg.isInitialized = true;
                            generatedCode.append("NODE ").append(result).append(" = MSNIL();\n");
                        }
                    }
                    generatedCode.append("hd(").append(result).append(", ").append(arg1).append(");\n");
                    break;
//                case IGNORE:
                default:
                    break;
            }
        }

        int paramCount = symbolTable.getFunc("main").parameters.length;
        int outputCount = symbolTable.getFunc("main").outputs.length;
        generatedCode.append("int main(int argc, char **argv) {\n");

        for (int i = 0; i < outputCount; i++)
            generatedCode.append("NODE result").append(i).append(";\n");
        generatedCode.append("vector<NODE> nodes;\n");
        generatedCode.append("if (!parseParameters(nodes, argc, argv)) return 1;\n");
        generatedCode.append("if (nodes.size() != ").append(paramCount).append(") { cout << \"Wrong number of parameters\" << endl; return 1; }");
        generatedCode.append("main_sanitized(");
        for (int i = 0; i < outputCount; i++) {
            generatedCode.append("result").append(i);

            if (i < outputCount - 1)
                generatedCode.append(", ");
        }
        for (int i = 0; i < paramCount; i++) {
            generatedCode.append(", ").append("nodes[").append(i).append("]");
        }
        generatedCode.append(");");
        for (int i = 0; i < outputCount; i++)
            generatedCode.append("cout << \"Result").append(i).append(": \";").append("ppln(result").append(i).append(");");
        generatedCode.append("return 0; \n}\n");

        return generatedCode.toString();
    }


}
