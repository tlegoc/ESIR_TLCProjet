package ThreeAddr;

import java.util.ArrayList;
import java.util.List;

public class Program {

    List<Line> lines = new ArrayList<>();

    public void addLine(Line l) {
        lines.add(l);
    }

    public boolean optimize() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Line line : lines) {
            result.append(line.op).append(":").append(line.res).append(", ").append(line.arg1).append(", ").append(line.arg2).append("\n");
        }

        return result.toString();
    }

    public Line getLastLine(int i) {
        return lines.get(lines.size() - 1 - i);
    }
}
