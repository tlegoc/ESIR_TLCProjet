import ThreeAddr.*;
import org.antlr.runtime.tree.CommonTree;


// S'occupe de creer le code intermediaire
// Pourrait etre BEAUCOUP plus optimise
// mais il marche
public class VisitorTA {
    private Program program = new Program();

    /***
     * Parcours l'AST pour generer le code 3 adresses
     * @param o L'arbre
     * @return Algorithme recursif, la valeur de retour est la variable/registre
     * qui a etee ecrite.
     */
    public Argument visit(Object o) {
        CommonTree tree = (CommonTree) o;
        String token = String.valueOf(tree);

        switch (token) {
            case "CONS":
                int childCount = tree.getChildCount();
                Registre cons_res = new Registre();

                // "We've had a first switch yes, but what about the second switch ?"
                //                                                      Pippin probably
                switch (childCount) {
                    // Appel de cons avec 2 arguments
                    case 2:
                        Argument arg1 = visit(tree.getChild(0));
                        Argument arg2 = visit(tree.getChild(1));
                        program.addLine(Line.Op.CONS, cons_res, arg1, arg2);
                        break;
                    case 1:
                        Argument arg = visit(tree.getChild(0));
                        program.addLine(Line.Op.CONS, cons_res, arg, new EmptyArgument());
                        break;
                    default:
                        // USED IN DEBUGGING
                        //TODO : REMOVE
                        program.addComment("CONST CONVERSION START");
                        program.addLine(Line.Op.ASSIGN, cons_res, visit(tree.getChild(tree.getChildCount() - 2)), new EmptyArgument());
                        for (int i = tree.getChildCount() - 2; i >= 0; i--) {
                            Registre tmp = new Registre();
                            program.addLine(Line.Op.CONS, tmp, visit(tree.getChild(i)), cons_res);
                            cons_res = tmp;
                        }

                        // USED IN DEBUGGING
                        //TODO : REMOVE
                        program.addComment("CONST CONVERSION END (result in " + cons_res.name + ")");
                        break;
                }
                return cons_res;

            case "ASSIGN_VARS":
                for(int i = 0; i < tree.getChildCount(); i ++) {
                    program.addLine(Line.Op.ASSIGNSET, visit(tree.getChild(i)), new EmptyArgument(), new EmptyArgument());
                }
                break;
            case "ASSIGN_EXPR":
                for(int i = 0; i < tree.getChildCount(); i ++) {
                    if(tree.getChild(i).toString().equals("SYMBOL")) {
                        visit(tree.getChild(i));
                    } else {
                        program.addLine(Line.Op.ASSIGN, visit(tree.getChild(i)), new EmptyArgument(), new EmptyArgument());
                    }
                }
                break;
            case "ASSIGN":
//                if (tree.getChild(0).getChildCount() != tree.getChild(1).getChildCount()) {
//                    System.out.println(ANSI_RED + "Error: assignation to " + tree.getChild(0).getChildCount() + " variables, but only " + tree.getChild(1).getChildCount() + " given." + ANSI_RESET);
//                }
                /*
                for (int i = 0; i < tree.getChild(0).getChildCount(); i++) {
                    Argument egal_res = visit(tree.getChild(0).getChild(i));
                    Argument egal_arg = visit(tree.getChild(1).getChild(i));
                    program.addLine(Line.Op.ASSIGN, egal_res, egal_arg, new EmptyArgument());
                }
                */
                visit(tree.getChild(0)); // Visite assignation
                visit(tree.getChild(1)); // Visite expressions
                break;
            // COMMANDS et BODY n'ont rien de special, on peut les grouper
            case "COMMANDS":
            case "BODY":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    visit(tree.getChild(i));
                }
                break;
            case "FUNC":
                program.addLine(Line.Op.FUNCBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                visit(tree.getChild(1));
                program.addLine(Line.Op.FUNCEND, new Symbol(String.valueOf(tree.getChild(0))));
                break;
                // Lors de la generation en code c++ on utilisera la table des symbols
                // pour generer la signature des fonctions qui condiendra ces variables
//            case "OUTPUT":
//                program.addLine(Line.Op.OUTPUT, new Symbol(String.valueOf(tree.getChild(0))));
//                break;
//            case "PARAM":
//                for (int i = 0; i < tree.getChildCount(); i++) {
//                    String p = String.valueOf(tree.getChild(i));
//                    program.addLine(Line.Op.PARAM, new Symbol(p));
//                }
//                break;
            case "FOR":
                program.addLine(Line.Op.FORBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                visit(tree.getChild(1));
                program.addLine(Line.Op.FOREND, new Symbol(String.valueOf(tree.getChild(0))));
                break;
            case "TL":
                Argument tl_arg = visit(tree.getChild(0));
                Registre tl_res = new Registre();
                program.addLine(Line.Op.TL, tl_res, tl_arg, new EmptyArgument());
                return tl_res;
            case "HD":
                Argument hd_arg = visit(tree.getChild(0));
                Registre hd_res = new Registre();
                program.addLine(Line.Op.HD, hd_res, hd_arg, new EmptyArgument());
                return hd_res;

            // Symbol is actually a function call
            case "SYMBOL":
                // TODO : REWRITE
                for (int i = 1; i < tree.getChildCount(); i++) {
                    Argument param_v = visit(tree.getChild(i));
                    if (param_v instanceof EmptyArgument) continue;
                    program.addLine(Line.Op.PARAMSET, param_v);
                }

                // Pourquoi faire un goto quand on peut faire un appel de fonction ?
                // Autant profiter des avantages de notre langage cible
                // Oui c'est de la triche
                program.addLine(Line.Op.CALL, new Symbol(String.valueOf(tree.getChild(0))), new EmptyArgument(), new EmptyArgument());
                break;
            case "LIST":
                // Pour simplifier la tache, on convertis directement LIST en appels de CONS
                // Evite de coder des fonctions à nombre de paramètres indéterminés, meme
                // si au final on souffre autant.
                // Les fonctions variadiques c'est une horreur

                // USED IN DEBUGGING
                //TODO REMOVE
                program.addComment("LIST CONVERSION START");

                Registre ls_res = new Registre();
                program.addLine(Line.Op.ASSIGN, ls_res, new Symbol("nil"), new EmptyArgument());
                for (int i = tree.getChildCount() - 1; i >= 0; i--) {
                    Registre tmp = new Registre();
                    program.addLine(Line.Op.CONS, tmp, visit(tree.getChild(i)), ls_res);
                    ls_res = tmp;
                }

                // USED IN DEBUGGING
                //TODO REMOVE
                program.addComment("LIST CONVERSION END (result in " + ls_res.name + ")");
                return ls_res;
            case "WHILE":
                program.addLine(Line.Op.WHILEBEGIN, new Symbol(String.valueOf(tree.getChild(0))));
                visit(tree.getChild(1));
                program.addLine(Line.Op.WHILEEND, new Symbol(String.valueOf(tree.getChild(0))));
                break;
            case "IF":
                Argument condition = visit(tree.getChild(0));
                program.addLine(Line.Op.IFBEGIN, condition);
                visit(tree.getChild(1));
                program.addLine(Line.Op.IFEND, condition);
                // Heureusement que l'arbre a toujours la meme forme, et qu'on peut
                // se permettre de faire ces verifications pas oufs
                if (tree.getChildCount() > 2) {
                    program.addLine(Line.Op.ELSEBEGIN, condition);
                    visit(tree.getChild(2));
                    program.addLine(Line.Op.ELSEEND, condition);
                }
                break;
            case "VIDE":
            case "PARAM":
                return new EmptyArgument();
            default:
                // Edge case, utile surtout pour le node root
                // en realite une idee de merde,
                // mais vu que seulement une fonction peut s'appeler nil et
                // qu'on traite les noeuds de nom de fonction differement,
                // on peut se permettre de faire ca.
                if (token.equals("nil")) {
                    for (int i = 0; i < tree.getChildCount(); i++) {
                        visit(tree.getChild(i));
                    }
                }
                return new Symbol(token);
        }

        // Impossible
        return new EmptyArgument();
    }

    public Program getProgram() {
        return program;
    }
}
