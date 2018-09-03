package parent.package3;

import java.util.Random;

public class CharGen {
    private static Random random = new Random(666);
    private static final char[] capiatals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static char[] generate() {
        char[] result = "".toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(capiatals[random.nextInt(capiatals.length)]);
        for (int i = 0; i < 5; i++) {
            sb.append(lowers[random.nextInt(lowers.length)]);
        }
        return sb.toString().toCharArray();
    }

    public static void main(String[] args) {

    }
}
