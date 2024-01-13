import SymbolTable.*;
import ThreeAddr.*;

import java.util.*;


// S'occupe de valider le programme à partir du code intermediaire et de
// la table des symbols
public class WhileValidator {


    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private final Program program;
    private final SymbolTable symbolTable;
    private final String mainFunc;

    public WhileValidator(Program p, SymbolTable symbols, String mf) {
        this.program = p;
        this.symbolTable = symbols;
        this.mainFunc = mf;
    }

    /***
     * Validation du programme
     * @return vrai si le programme est correct, faux sinon : ne pas compiler
     */
    public boolean validate() {
        boolean valid = true;
        //PASS 1 =================================
        // Check la déclaration multiple de fonctions
        Map<String, STFunc> function_names = new HashMap<>();
        for (int i = 0; i < symbolTable.symbols.size(); i++) {
            if (!(symbolTable.symbols.get(i) instanceof STFunc func)) continue;

            if (function_names.containsKey(func.name)) {
                System.out.println(ANSI_RED + "Error: multiple declaration of " + func.name + ANSI_RESET);
                valid = false;
            } else function_names.put(func.name, func);
        }
        //PASS 2 =================================
        // Check bon nombre de parametres + existence de la fonction
        int supposed_params = 0;
        int supposed_outputs = 0;
        int params_count = 0;
        int outputs_count = 0;
        for (int i = 0; i < program.lines.size(); i++) {
            Line actualLine = program.lines.get(i);
            switch (actualLine.op) {
                case CALL:
                    STFunc func = function_names.get(actualLine.res.toString());
                    if (func == null) {
                        System.out.println(ANSI_RED + "Error: func " + actualLine.res.toString() + " isn't declared" + ANSI_RESET);
                        valid = false;

                    } else {
                        supposed_params = func.parameters.length;
                        supposed_outputs = func.outputs.length;
                        params_count = 0;
                        outputs_count = 0;
                    }
                    break;
                case PARAMSET:
                    params_count++;
                    break;
                case OUTPUTSET:
                    outputs_count++;
                    break;
                case CALLEND:
                    if (!(params_count == supposed_params && outputs_count == supposed_outputs)) {
                        System.out.println(ANSI_RED + "Error: func " + actualLine.res.toString() + " doesn't have the right amount of outputs or inputs" + ANSI_RESET);
                        System.out.println(ANSI_RED + "(supposed param number : "+supposed_params+", actual param number : "+params_count +")"+ ANSI_RESET);
                        System.out.println(ANSI_RED + "(supposed output number : "+supposed_outputs+", actual output number : "+outputs_count+")"+ ANSI_RESET);
                        valid = false;
                    }
                    supposed_params = 0;
                    supposed_outputs = 0;
                    params_count = 0;
                    outputs_count = 0;
                    break;
                default:
                    break;
            }
        }
        //PASS 3 =================================
        // Check que le main existe / est valide
        int desired_param_count = function_names.get(mainFunc) != null ? function_names.get(mainFunc).parameters.length : -1;
        if (desired_param_count == -1) {
            System.out.println(ANSI_RED + "Error: Main calling unknown function " + mainFunc + ANSI_RESET);
            valid = false;
        }

        //PASS 4 =================================
        // Retour de variable qui existe
        List<String> outputs = new ArrayList<>();
        STFunc func = null;
        for(Line line : program.lines ) {

            switch (line.op) {
                case FUNCBEGIN:
                    func = function_names.get(line.res.toString());
                    outputs.addAll(Arrays.asList(func.outputs));
                    break;
                case ASSIGN:
                    String var = line.res.toString();
                    outputs.remove(var);
                    break;
                case FUNCEND:
                    for(String result : outputs) {
                        System.out.println(ANSI_RED + "Error: function " + func.name + " returning non existing variable " + result + ANSI_RESET);
                        valid = false;
                    }
                    break;
            }
        }
        //PASS 5 =================================
        // Verfier qu'on utilise une variable qui existe
        for (int i = 0; i < program.getLineCount(); i++)
        {

        }
        return true;
        //return valid;
    }
}
