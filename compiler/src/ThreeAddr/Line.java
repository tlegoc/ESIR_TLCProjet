package ThreeAddr;

public class Line {


    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public enum Op {
        PARAM,
        PARAMSET,
        FUNCBEGIN,
        FUNCEND,
        OUTPUT,
        CONS,
        ASSIGN,
        TL,
        HD,
        IFBEGIN,
        IFEND,
        ELSEBEGIN,
        ELSEEND,
        WHILEBEGIN,
        WHILEEND,
        FORBEGIN,
        FOREND,
        CALL,
        IGNORE
    }
    public Argument res;
    public Argument arg1;
    public Argument arg2;
    public Op op;

    public Line(Op _op, Argument _res, Argument _arg1, Argument _arg2)
    {
        op = _op;
        arg1 = _arg1;
        arg2 = _arg2;
        res = _res;
    }

    public String toString(boolean colored)
    {
        StringBuilder result = new StringBuilder();
        Line line = this;
        if (!colored);
        else if (line.op == Line.Op.FUNCBEGIN || line.op == Line.Op.FUNCEND || line.op == Line.Op.PARAM)
            result.append(ANSI_GREEN);
        else if (line.op == Line.Op.FORBEGIN || line.op == Line.Op.FOREND || line.op == Line.Op.WHILEBEGIN || line.op == Line.Op.WHILEEND || line.op == Line.Op.IFBEGIN || line.op == Line.Op.IFEND || line.op == Line.Op.ELSEBEGIN || line.op == Line.Op.ELSEEND)
            result.append(ANSI_YELLOW);
        else if (line.op == Line.Op.CALL || line.op == Line.Op.PARAMSET) result.append(ANSI_RED);
        else if (line.op == Line.Op.OUTPUT) result.append(ANSI_BLUE);
        else if (line.op == Line.Op.ASSIGN) result.append(ANSI_PURPLE);
        else if (line.op == Line.Op.IGNORE) result.append(ANSI_CYAN);
        else result.append(ANSI_RESET);
        result.append(line.op).append(" ".repeat(10 - String.valueOf(line.op).length())).append("\t").append(line.res);
        if (!(line.arg1 instanceof EmptyArgument)) {
            result.append("\t").append(line.arg1);
            if (!(line.arg2 instanceof EmptyArgument)) {
                result.append("\t").append(line.arg2);
            }
        }

        if (colored) result.append(ANSI_RESET);

        return result.toString();
    }

    public String toString()
    {
        return toString(false);
    }
}
