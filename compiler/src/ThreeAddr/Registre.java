package ThreeAddr;

import java.util.Random;

public class Registre implements Argument {
    public String name = "";

    public Registre()
    {
        Random r = new Random();
        name = "res" + r.nextInt(1000000);
    }

    @Override
    public String toString() {
        return name;
    }
}
