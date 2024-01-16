package ThreeAddr;

public class BlockName implements Argument {
    public String name;
    public BlockName(String n) {
        this.name = n;
    }
    public String toString() {
        return name;
    }

}
