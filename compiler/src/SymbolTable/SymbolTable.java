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
     * @param currentScope block actuel
     * @return liste des variables du block actuel
     */
    public List<STEntry> getEntriesForScope(int currentScope, boolean considerParams, boolean considerOutputs) {
        if (currentScope > getScopeCount()) return new ArrayList<>();

        List<STEntry> entries = new ArrayList<>();

        int scope = 0;
        for (int i = 0; i < symbols.size() && scope < currentScope + 1 && scope < getScopeCount(); i++) {
            if (symbols.get(i) instanceof STBlockStart || symbols.get(i) instanceof STBlockEnd) {
                scope++;
                continue;
            }

            if (scope == currentScope) {
                if (symbols.get(i) instanceof STVariable)
                    entries.add(symbols.get(i));

                else if (symbols.get(i) instanceof STFunc func) {
                    if (considerParams)
                        for (String params : func.parameters) {
                            entries.add(new STVariable(params));
                        }
                    if (considerOutputs)
                        for (String outputs : func.outputs) {
                            entries.add(new STVariable(outputs));
                        }
                }
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
    // une variable accessible est une variable qui est dans un scope qui entoure le scope donné
    public List<STEntry> getAccessibleEntries(int scope) {
        if (scope >= getScopeCount()) return new ArrayList<>();

        int depth = getDepthAtScope(scope);
//        System.out.println("depth: " + depth);
        List<STEntry> entries = new ArrayList<>();

        for (int currentScope = scope; currentScope > 0; currentScope--) {
            int currentDepth = getDepthAtScope(currentScope);
//            System.out.println("currentDepth: " + currentDepth);
            if (currentDepth <= 0) break;
            if (currentDepth > depth) continue;

            entries.addAll(getEntriesForScope(currentScope, true, true));
        }

        return entries;
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

        for (STEntry entry : symbols) {
            //String name = entry.getClass().getName();
            s.append(entry.toString());
            s.append("\n");
        }

        System.out.println(s);
    }
}
