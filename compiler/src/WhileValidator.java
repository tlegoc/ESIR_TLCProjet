import SymbolTable.*;
import ThreeAddr.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// S'occupe de valider le programme à partir du code intermediaire et de
// la table des symbols
public class WhileValidator {


    // TODO : Virer ces foutus codes ANSI
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
        // TODO : REWRITE
        //PASS 3 =================================
        // Check que le main existe / est valide
        int desired_param_count = function_names.get(mainFunc) != null ? function_names.get(mainFunc).parameters.length : -1;
        if (desired_param_count == -1) {
            System.out.println(ANSI_RED + "Error: Main calling unknown function " + mainFunc + ANSI_RESET);
            valid = false;
        }
        else if (desired_param_count != 0) {
            System.out.println(ANSI_RED + "Error: Main function has more than 0 parameters." + ANSI_RESET);
            valid = false;
        }
        //PASS 4 =================================
        // Retour de variable qui existe
        /*TODO : La variable existera toujours car ajoutee dans la table des symboles
            dans tous les cas. Il faudrait pluttôt verifier si dans la fonction on ecrit
            au moins une fois dans le resultat.*/
        // TODO : REWRITE
        String current_result_to_find = "";
        String current_func = "";
        for (int i = 0; i < symbolTable.symbols.size(); i++) {
            if (symbolTable.symbols.get(i) instanceof STFunc func) {

                if (!current_result_to_find.isEmpty()) {
                    System.out.println(ANSI_RED + "Error: function " + current_func + "returning non existing variable " + current_result_to_find + ANSI_RESET);
                    valid = false;
                }
                current_result_to_find = func.outputs[0];
                current_func = func.name;
            } else if (symbolTable.symbols.get(i) instanceof STVariable vari) {

                if (current_result_to_find.equals(vari.name)) current_result_to_find = "";
            }
        }
        //PASS 1 =================================
        // Verfier qu'on utilise une variable qui existe
        for (int i = 0; i < program.getLineCount(); i++)
        {

        }
        return valid;
    }
}
