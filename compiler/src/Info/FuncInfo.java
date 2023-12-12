package Info;

public class FuncInfo extends Info {
    public int inputs;
    public int outputs;

    @Override
    public String toString() {
        return ID +", "+inputs+", "+outputs;
    }
}
