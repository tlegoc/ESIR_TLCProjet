public class Symbol extends Tree {

    public Symbol(char v)
    {
        value = v;
    }

    public Tree copy()
    {
        return new Symbol(value);
    }

    public Tree getLeftChild() {
        return new Nil();
    }

    public Tree getRightChild() {
        return new Nil();
    }

    public char value;

    protected String type = "symbol";

    public String toString() {
        return String.valueOf(value);
    }

    public int toInt() {
        return 0;
    }

    public boolean toBoolean() {
        return false;
    }
}
