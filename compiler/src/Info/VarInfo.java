package Info;

public class VarInfo extends Info{
    public boolean isParam;

    public VarInfo(String id, boolean p) {
        ID = id;
        isParam = p;
    }

    @Override
    public String toString() {
        if(isParam) { return ID+" is param";}
        else { return ID+" is var";}
    }
}
