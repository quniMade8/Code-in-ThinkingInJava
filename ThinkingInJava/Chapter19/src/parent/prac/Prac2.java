package parent.prac;

import java.util.Date;
import java.util.Random;

enum CartoonCharactor {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    public static CartoonCharactor next() {
        Random random = new Random(new Date().getTime());
        return values()[random.nextInt(values().length)];
    }
}

public class Prac2 {
    public static void main(String[] args) {
        System.out.println(CartoonCharactor.next().name());
    }
}
