package ThreeAddr;

import java.util.ArrayList;
import java.util.List;

public class Program {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    List<Line> lines = new ArrayList<>();

    public void addLine(Line.Op op, Argument res) {
        addLine(op, res, new EmptyArgument(), new EmptyArgument());
    }

    public void addLine(Line.Op op, Argument res, Argument arg1, Argument arg2) {
        addLine(new Line(op, res, arg1, arg2));
    }

    public void addLine(Line l) {
        lines.add(l);
    }

    public void addComment(String comment) {
        addLine(Line.Op.IGNORE, new Symbol(comment));
    }

    public boolean optimize() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Line line : lines) {
            if (line.op == Line.Op.FUNCBEGIN || line.op == Line.Op.FUNCEND || line.op == Line.Op.PARAM)
                result.append(ANSI_GREEN);
            else if (line.op == Line.Op.FORBEGIN || line.op == Line.Op.FOREND || line.op == Line.Op.WHILEBEGIN || line.op == Line.Op.WHILEEND || line.op == Line.Op.IFBEGIN || line.op == Line.Op.IFEND || line.op == Line.Op.ELSEBEGIN || line.op == Line.Op.ELSEEND)
                result.append(ANSI_YELLOW);
            else if (line.op == Line.Op.CALL || line.op == Line.Op.PARAMSET) result.append(ANSI_RED);
            else if (line.op == Line.Op.OUTPUT) result.append(ANSI_BLUE);
            else if (line.op == Line.Op.ASSIGN) result.append(ANSI_PURPLE);
            else if (line.op == Line.Op.IGNORE) result.append(ANSI_CYAN);
            else result.append(ANSI_RESET);
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
