import java.util.ArrayList;

public class SpaghettiStack {
    private ArrayList<String> line = new ArrayList<String>();
    private ArrayList<SpaghettiStack> children = new ArrayList<SpaghettiStack>();

    public SpaghettiStack() {}
    
    public ArrayList<String> getLine() {
        return line;
    }

    public ArrayList<SpaghettiStack> getChildren() {
        return children;
    }

    public SpaghettiStack getChild(int i) {
        return children.get(i);
    }

    public int getChildrenCount() {
        return children.size();
    }

    public void addChild(SpaghettiStack child) {
        children.add(child);
    }

    public void addToLine(String str) {
        this.line.add(str);
    }

}
