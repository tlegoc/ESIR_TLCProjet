package SymbolTable;

public class STVariable extends STEntry {
    public String name;

    public STVariable(String n) {
        this.name = n;
    }

    public String toString() {
        return "Var name : " + name;
    }

    public String getSymbol()
    {
        return name;
    }
}
