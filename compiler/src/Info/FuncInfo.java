package Info;

public class FuncInfo extends Info {
    public int inputs;
    public int outputs;

    public FuncInfo(String id, int in, int out) {
        ID = id;
        inputs = in;
        outputs = out;
    }

    @Override
    public String toString() {
        return ID +", "+inputs+", "+outputs;
    }
}
