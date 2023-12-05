package ThreeAddr;

public class Line {

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
}
