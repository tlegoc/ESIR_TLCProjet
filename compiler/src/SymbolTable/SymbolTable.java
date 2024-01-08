package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    public List<STEntry> symbols = new ArrayList<>();

    public void add(STEntry entry) {

        // Verification que la variable n'existe pas deja
        // pas fou
        if (!(entry instanceof STVariable)) {
            symbols.add(entry);
            return;
        }

        boolean exists = false;
        int found_depth = 0;
        int depth = 0;
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) instanceof STBlockStart) depth++;
            else if (symbols.get(i) instanceof STBlockEnd) {
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
        if (!exists) symbols.add(entry);
    }

    public List<STEntry> getEntriesForScope(int currentScope) {
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
            }
        }

        return entries;
    }

    public int getScopeCount() {
        int res = 0;
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
            String name = entry.getClass().getName();
            s.append(entry);
            s.append("\n");
        }

        System.out.println(s);
    }
}
