package old_runtime;

public class Nil extends Tree {

    public Tree copy() {
        return new Nil();
    }

    public Tree getLeftChild() {
        return new Nil();
    }

    public Tree getRightChild() {
        return new Nil();
    }

    protected String type = "nil";

    public String toString() {
        return "";
    }

    public int toInt() {
        return 0;
    }

    public boolean toBoolean() {
        return false;
    }
}