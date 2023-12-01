package ThreeAddr;

public class Variable implements Argument {
    public String name = "";

    Variable(String _name) {
        name = _name;
    }

    @Override
    public String toString() {
        return name;
    }
}
