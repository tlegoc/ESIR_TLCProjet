package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    public List<STEntry> symbols = new ArrayList<>();

    public void add(STEntry entry) {
        boolean exists = false;
        //verif pour STFunc
        if (entry instanceof STFunc) {
            //TODO verif pour STFunc
        }
        //verif pour STVariable
        else if (entry instanceof STVariable) {
            int found_depth = 0;
            int depth = 0;
            for (int i = 0; i < symbols.size(); i++) {
                if (symbols.get(i) instanceof STBlockStart) {
                    depth++;
                } else if (symbols.get(i) instanceof STBlockEnd) {
                    depth--;
                    if (depth < found_depth) exists = false;
                } else if (symbols.get(i) instanceof STVariable && symbols.get(i).getSymbol().equals(entry.getSymbol())) {
                    found_depth = depth;
                    exists = true;
                } else if (symbols.get(i) instanceof STFunc func) {
                    for (String output : func.outputs) {
                        if (output.equals(entry.getSymbol())) {
                            found_depth = depth;
                            exists = true;
                            break;
                        }
                    }
                    for (String params : func.parameters) {
                        if (params.equals(entry.getSymbol())) {
                            found_depth = depth;
                            exists = true;
                            break;
                        }
                    }
                }
            }
        }
        /*
        System.out.println("[DEBUG TS] - add - exists : " + exists);
        System.out.println("[DEBUG TS] - add - entry name : " + entry.toString());
         */
        if (!exists) symbols.add(entry);
    }

    /**
     * Retourne les variables du block actuel seulement
     *
     * @param scope block actuel
     * @return liste des variables du block actuel
     */
    public List<STEntry> getEntriesForScope(int scope) {
        List<STEntry> entries = new ArrayList<>();
        int current_scope = 0;
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) instanceof STBlockStart) {
                current_scope++;
                if (current_scope > scope) break;
            } else if (symbols.get(i) instanceof STBlockEnd) {
                current_scope++;
                if (current_scope > scope) break;
            } else if (current_scope == scope) {
                entries.add(symbols.get(i));
            }
        }

        return entries;
    }

    public int getDepthAtScope(int scope) {
        int depth = 0;
        int current_scope = 0;
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) instanceof STBlockStart) {
                current_scope++;
                depth++;
                if (current_scope > scope) break;
            } else if (symbols.get(i) instanceof STBlockEnd) {
                current_scope++;
                depth--;
                if (current_scope > scope) break;
            }
        }

        return depth;
    }

    /**
     * Retourne les variables accessibles dans le scope donné
     *
     * @param scope
     * @return liste des variables accessibles dans le scope donné
     */
    public List<STEntry> getAccessibleEntries(int scope, boolean considerParams, boolean considerOutputs) {
        if (scope > getScopeCount()) return new ArrayList<>();

        List<STEntry> res = new ArrayList<>();

        int currentScope = 0;

        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) instanceof STBlockStart) {
                currentScope++;
                if (currentScope > scope) break;
                res.add(new STBlockStart());
            } else if (symbols.get(i) instanceof STBlockEnd) {
                for (int j = res.size() - 1; j >= 0; j--) {
                    if (!(res.get(j) instanceof STBlockStart))
                        res.remove(j);
                    else {
                        res.remove(j);
                        break;
                    }
                }
                currentScope++;
            } else if (symbols.get(i) instanceof STVariable var) {
                res.add(var);
            } else if (symbols.get(i) instanceof STFunc func) {
                if (considerParams)
                    for (String param : func.parameters) {
                        res.add(new STVariable(param));
                    }
                if (considerOutputs)
                    for (String output : func.outputs) {
                        res.add(new STVariable(output));
                    }
            }
        }

        return res.stream().filter((entry) -> entry instanceof STVariable).toList();
    }

    public int getScopeCount() {
        int res = 1;
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) instanceof STBlockStart || symbols.get(i) instanceof STBlockEnd) res++;
        }

        return res;
    }

    public STFunc getFunc(String funcName) {
        for (STEntry symbol : symbols) {
            if (symbol instanceof STFunc func) {
                if (func.name.equals(funcName)) return func;
            }
        }
        return null;
    }

    public void printSymbolTable() {
        StringBuilder s = new StringBuilder();

        int depth = 0;
        for (STEntry entry : symbols) {
            if (entry instanceof STBlockEnd) {
                depth--;
            }
            s.append("  ".repeat(Math.max(0, depth)));
            //String name = entry.getClass().getName();
            s.append(entry.toString());
            s.append("\n");
            if (entry instanceof STBlockStart) {
                depth++;
            }
        }

        System.out.println(s);
    }
}
