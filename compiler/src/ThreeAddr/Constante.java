package ThreeAddr;

public class Constante implements Argument {
    String value = "";

    public Constante(String _value)
    {
        value = _value;
    }

    @Override
    public String toString() {
        return value;
    }
}
