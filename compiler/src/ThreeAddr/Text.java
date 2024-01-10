package ThreeAddr;

public class Text implements Argument {

    public String name;

    public Text(String _name) {
        name = _name;
    }

    @Override
    public String toString() {
        return name;
    }
}
