package old_runtime;

public class Node extends Tree {

    public Node() {
        this(new Nil(), new Nil());
    }

    public Node(Tree lc, Tree rc) {
        leftChild = lc;
        rightChild = rc;
    }

    public Tree copy() {
        Node n = new Node();

        n.leftChild = leftChild.copy();
        n.rightChild = rightChild.copy();

        return n;
    }

    public Tree getLeftChild() {
        return leftChild;
    }

    public Tree getRightChild() {
        return rightChild;
    }

    private Tree leftChild;
    private Tree rightChild;

    protected String type = "node";

    public String toString() {
        return getLeftChild().toString() + getRightChild().toString();
    }

    public int toInt() {
        return 1 + getRightChild().toInt();
    }

    public boolean toBoolean() {
        return true;
    }
}