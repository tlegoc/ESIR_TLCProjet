package ThreeAddr;

import java.util.ArrayList;
import java.util.List;

public class Program {

    List<Line> lines = new ArrayList<>();

    public void addLine(Line.Op op, Argument res, Argument arg1, Argument arg2) {
        addLine(new Line(op, res, arg1, arg2));
    }

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
            result.append(line.op).append(" ".repeat(10 - String.valueOf(line.op).length())).append(":\t").append(line.res);
            if (!(line.arg1 instanceof EmptyArgument)) {
                result.append(",\t").append(line.arg1);
                if (!(line.arg2 instanceof EmptyArgument)) {
                    result.append(",\t").append(line.arg2);
                }
            }
            result.append("\n");
        }

        return result.toString();
    }

    public Line getLastLine(int i) {
        return lines.get(lines.size() - 1 - i);
    }
}
