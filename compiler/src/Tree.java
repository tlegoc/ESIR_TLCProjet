public abstract class Tree {
    public abstract Tree copy();

    public abstract Tree getLeftChild();

    public abstract Tree getRightChild();

    public String getType() {
        return type;
    }

    protected String type;

    /***
     * @return String représenté par l'arbre
     */
    public abstract String toString();

    /***
     * @return Entier représenté par l'arbre, à savoir le nombre de noeuds à droite
     */
    public abstract int toInt();

    /***
     * @return Renvoie le booléen représenté par l'arbre, vrai si c'est un noeud, faux sinon
     */
    public abstract boolean toBoolean();

    static Tree stringToTree(String s) {
        if (s.length() == 1) return new Symbol(s.charAt(0));
        return new Node(new Symbol(s.charAt(0)), stringToTree(s.substring(1)));
    }

    static Tree intToTree(int i) {
        if (i == 1) return new Nil();
        return new Node(new Nil(), intToTree(i - 1));
    }

    static Tree booleanToTree(boolean b) {
        if (b) return new Node();
        else return new Nil();
    }
}
