package ThreeAddr;

public class Symbol implements Argument {
    public String name = "";

    public Symbol(String _name) {
        char[] tmp = new char[2];
        _name.toLowerCase().getChars(0, 1, tmp, 0);
        _name.getChars(0, 1, tmp, 1);
        if (tmp[0] != tmp[1]) {
            throw new RuntimeException("Error: symbol should start with a lower case letter.");
        }
        name = _name;
    }

    @Override
    public String toString() {
        return name;
    }
}
