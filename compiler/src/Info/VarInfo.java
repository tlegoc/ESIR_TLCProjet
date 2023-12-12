package Info;

public class VarInfo extends Info{
    public boolean isParam;
    @Override
    public String toString() {
        if(isParam) { return ID+" is param";}
        else { return ID+"is var";}
    }
}
