package SymbolTable;

public class STFunc extends STEntry {
    public String[] parameters;
    public String name;
    public String[] outputs;

    public STFunc(String n, String[] p, String[] o) {
        name = n;
        parameters = p;
        outputs = o;
    }

    public String toString() {
        return "Func name: " + name + "; Param count: " + parameters.length + "; output count : " + outputs.length;
    }

    public String getSymbol()
    {
        return name;
    }
}
