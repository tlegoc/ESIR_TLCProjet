package ThreeAddr;

public class Symbol implements Argument {
    public String name = "";

    public Symbol(String _name) {
        name = _name;
    }

    @Override
    public String toString() {
        return name;
    }
}
