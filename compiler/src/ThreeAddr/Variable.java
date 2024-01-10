package ThreeAddr;

public class Variable  implements Argument {
    public String name = "";

    public Variable(String _name) {
        char[] tmp = new char[2];
        _name.toUpperCase().getChars(0, 1, tmp, 0);
        _name.getChars(0, 1, tmp, 1);
        if (tmp[0] != tmp[1]) {
            throw new RuntimeException("Error: variable should start with a upper case letter.");
        }
        name = _name;
    }

    @Override
    public String toString() {
        return name;
    }
}
