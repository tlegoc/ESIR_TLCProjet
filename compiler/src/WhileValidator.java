import SymbolTable.*;
import ThreeAddr.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WhileValidator {


    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private Program program;

    private SymbolTable ts;

    public WhileValidator(Program p, SymbolTable symbols) {
        program = p;
        ts = symbols;
    }

    public boolean validate() {
        boolean not_valid = false;

        // Déclaration multiple de fonctions
        Map<String, STFunc> function_names = new HashMap<>();
        for (int i = 0; i < ts.symbols.size(); i++) {
            if (!(ts.symbols.get(i) instanceof STFunc)) continue;

            STFunc func = (STFunc) ts.symbols.get(i);

            if (function_names.containsKey(func.name)) {
                System.out.println(ANSI_RED + "Error: multiple declaration of " + func.name + ANSI_RESET);
                not_valid = true;
            } else function_names.put(func.name, func);
        }

        // Check bon nombre de parametre
        for (int i = 0; i < program.lines.size(); i++) {
            if (program.lines.get(i).op == Line.Op.CALL) {
                int j = i;
                int params_count = 0;
                while (j > 0) {
                    if (program.lines.get(j).op == Line.Op.PARAMSET) {
                        params_count++;
                    }
                    j--;
                    if (program.lines.get(j).op == Line.Op.CALL) break;
                }

                // compare actual parameter and desired parameters
                String func_name = ((Symbol) program.lines.get(i).arg1).name;
                int desired_param_count = function_names.get(func_name) != null ? function_names.get(func_name).paramCount : -1;
                if (desired_param_count == -1) {
                    System.out.println(ANSI_RED + "Error: Unknown function " + func_name + ANSI_RESET);
                    not_valid = true;
                }
                else if (desired_param_count != params_count) {
                    System.out.println(ANSI_RED + "Error: function called with wrong number of params " + func_name + ANSI_RESET);
                    not_valid = true;
                }
            }
        }

        // Retour de variable qui existe
        int depth = 0;
        String current_result_to_find = "";
        String current_func = "";
        for (int i = 0; i < ts.symbols.size(); i++) {
            if (ts.symbols.get(i) instanceof STFunc) {
                STFunc func = (STFunc) ts.symbols.get(i);

                if (current_result_to_find.isEmpty()) {
                    current_result_to_find = func.return_var;
                    current_func = func.name;
                } else {
                    System.out.println(ANSI_RED + "Error: function " + current_func + "returning non existing variable " + current_result_to_find + ANSI_RESET);
                    not_valid = true;
                    current_result_to_find = func.return_var;
                    current_func = func.name;                }
            } else if (ts.symbols.get(i) instanceof STVariable) {
                STVariable vari = (STVariable) ts.symbols.get(i);

                if (current_result_to_find.equals(vari.name)) current_result_to_find = "";
            }
        }

        // Verfier qu'on utilise une variable qui existe

//        return false;
        return !not_valid;
    }
}
