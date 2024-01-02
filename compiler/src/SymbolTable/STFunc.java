package SymbolTable;

public class STFunc extends STEntry {
    public int paramCount;
    public String name;

    public String return_var;

    public STFunc(String n, int pc, String rv) {
        name = n;
        paramCount = pc;
        return_var = rv;
    }

    public String toString() {
        return "Func name: " + name + "; Param count: " + paramCount + "; return var: " + return_var;
    }

    public String getSymbol()
    {
        return name;
    }
}
