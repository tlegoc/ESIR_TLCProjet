import org.antlr.runtime.tree.Tree;

class Helpers
{
    public static String getFormattedPosition(Tree tree)
    {
        return "(" + tree.getLine() + ":" + tree.getCharPositionInLine() + ")";
    }
}