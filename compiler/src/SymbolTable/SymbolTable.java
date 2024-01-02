package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    public List<STEntry> symbols = new ArrayList<>();

    public void add(STEntry entry) {
        boolean exists = false;
        int found_depth = 0;
        int depth = 0;
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) instanceof STBlockStart) depth++;
            else if (symbols.get(i) instanceof STBlockEnd) {
                depth--;
                if (depth < found_depth) exists = false;
            } else if (symbols.get(i) instanceof STVariable && symbols.get(i).toString().equals(entry.toString())) {
                found_depth = depth;
                exists = true;
            }
        }
        if (!exists) symbols.add(entry);
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
