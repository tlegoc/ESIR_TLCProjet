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

    private String toStringAux(int i){
        String s = "";
        for (int j = 0; j < i; j++){
            s += " ";
        }
        s += "BLOC"+i+"{\n";
        for (String str : line) {
            for (int j = 0; j <= i; j++){
                s += " ";
            }
            s += str + "\n";
        }
        for (SpaghettiStack child : children) {
            s += child.toStringAux(i + 1);
        }
        for (int j = 0; j < i; j++){
            s += " ";
        }
        s += "}\n";
        return s;
    }
    public String toString() {
        return toStringAux(0);
    }

}
