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

    public List<Line> lines = new ArrayList<>();

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
        addLine(Line.Op.IGNORE, new Text(comment));
    }

    public void optimize() {

    }

    @Override
    public String toString() {
        return getProgramString();
    }

    public String getProgramString(boolean colored)
    {
        StringBuilder result = new StringBuilder();
        for (Line line : lines) {
            result.append(line.toString(colored)).append("\n");
        }

        if (colored) result.append(ANSI_RESET);

        return result.toString();
    }

    public String getProgramString()
    {
        return getProgramString(false);
    }

    public int getLineCount() {
        return lines.size();
    }

    public Line getLine(int i){
        return lines.get(i);
    }

    public Line getLastLine(int i) {
        return lines.get(lines.size() - 1 - i);
    }
}
