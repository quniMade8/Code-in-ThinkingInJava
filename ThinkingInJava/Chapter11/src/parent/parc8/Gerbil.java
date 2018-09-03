package parent.parc8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Gerbil {
    private static long counter;
    private long gerbilNumber = counter++;

    public void hop() {
        System.out.print("Gerbil " + gerbilNumber);
        System.out.println(" is jumping");
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<Gerbil>(Arrays.asList(new Gerbil(), new Gerbil(), new Gerbil()));
        Iterator<Gerbil> it = gerbils.listIterator();
        while (it.hasNext()) {
            it.next().hop();
        }
    }

}
