package ThreeAddr;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Registre implements Argument {
    public String name = "";

//    public static Set<String> taken_ids = new HashSet<>();
    public static int current_reg = -1;


    public Registre() {
//        Random r = new Random();
//        // Avoid using already existing ids
//        do {
//            name = "reg_" + r.nextInt(100000000);
//        } while (taken_ids.contains(name));
        name = "reg_" + ++current_reg;
    }
    @Override
    public String toString() {
        return name;
    }
}
