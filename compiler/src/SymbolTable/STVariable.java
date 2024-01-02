package SymbolTable;

public class STVariable extends STEntry {
    public String name;
    public boolean isParam;

    public STVariable(String n, boolean ip) {
        this.name = n;
        this.isParam = ip;
    }

    public String toString() {
        return "Var name : " + name;
    }

    public String getSymbol()
    {
        return name;
    }
}
