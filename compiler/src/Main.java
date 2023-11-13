

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Tree t1 = Tree.stringToTree("Hello world!");

        // Doit afficher Hello world!
        System.out.println(t1);
        // Doit afficher true
        System.out.println(t1.toBoolean());
        // Doit afficher 11
        System.out.println(t1.toInt());

        Tree ttrue = new Node();

        // Doit afficher ""
        System.out.println(ttrue);
        // Doit afficher true
        System.out.println(ttrue.toBoolean());
        // Doit afficher 1
        System.out.println(ttrue.toInt());

        Tree tfalse = new Nil();

        // Doit afficher ""
        System.out.println(tfalse);
        // Doit afficher false
        System.out.println(tfalse.toBoolean());
        // Doit afficher 0
        System.out.println(tfalse.toInt());

        // Doit afficher "a"
        System.out.println(new Symbol('a'));
        // Doit afficher false
        System.out.println(new Symbol('a').toBoolean());
        // Doit afficher 0
        System.out.println(new Symbol('a').toInt());
    }
}