import Info.Info;

import java.util.ArrayList;

public class SpaghettiStack {
    private ArrayList<Info> line = new ArrayList<Info>();
    private ArrayList<SpaghettiStack> children = new ArrayList<SpaghettiStack>();
    public SpaghettiStack papa;
    public SpaghettiStack() {}
    
    public ArrayList<Info> getLine() {
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
        child.papa = this;
    }

    public void addToLine(Info str) {
        this.line.add(str);
    }

    private String toStringAux(int i){
        String s = "";
        for (int j = 0; j < i; j++){
            s += " ";
        }

        s += "BLOC {\n";
        for (Info info : line) {
            for (int j = 0; j <= i; j++){
                s += "  ";
            }
            s += info.toString() + "\n";
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
