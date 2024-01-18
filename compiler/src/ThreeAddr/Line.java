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
        PARAMSET,
        OUTPUTSET,
        FUNCBEGIN,
        FUNCEND,
        CONS,
        ASSIGN,
        TL,
        HD,
        CALL,
        EQUALSINTER,
        IGNORE,
        BLOCK,
        BLOCKEND,
        JGREATER,
        JEQUALS,
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
        else if (line.op == Line.Op.FUNCBEGIN || line.op == Line.Op.FUNCEND)
            result.append(ANSI_GREEN);
        else if (line.op == Op.BLOCK || line.op == Op.BLOCKEND || line.op == Op.JEQUALS || line.op == Op.JGREATER )
            result.append(ANSI_YELLOW);
        else if (line.op == Line.Op.CALL || line.op == Line.Op.PARAMSET || line.op == Op.OUTPUTSET) result.append(ANSI_RED);
//        else if (line.op == Line.Op.OUTPUT) result.append(ANSI_BLUE);
        else if (line.op == Line.Op.ASSIGN || line.op == Op.EQUALSINTER) result.append(ANSI_PURPLE);
        else if (line.op == Line.Op.IGNORE) result.append(ANSI_CYAN);
        else result.append(ANSI_RESET);
        result.append(line.op).append(" ".repeat(13 - String.valueOf(line.op).length())).append("\t").append(line.res);
        if (!(line.arg1 instanceof EmptyArgument)) {
            result.append("\t").append(line.arg1);
            if (!(line.arg2 instanceof EmptyArgument)) {
                result.append("\t").append(line.arg2);
            }
        }

        if (colored) result.append(ANSI_RESET);

        return result.toString();
    }
    public boolean compareArgs(Line l) {
        return  this.arg1.toString().equals(l.arg1.toString()) &&
                this.arg2.toString().equals(this.arg2.toString());
    }
    public boolean compareRes(Line l) {
        return  this.res.toString().equals(l.res.toString());
    }
    public boolean compare(Line l) {
        return compareArgs(l) && compareRes(l);
    }

    public String toString()
    {
        return toString(false);
    }
}
