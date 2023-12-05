package ThreeAddr;

import java.util.Random;

public class Registre implements Argument {
    public String name = "";

    public Registre()
    {
        Random r = new Random();
        name = "reg_" + r.nextInt(100000000);
    }

    @Override
    public String toString() {
        return name;
    }
}
