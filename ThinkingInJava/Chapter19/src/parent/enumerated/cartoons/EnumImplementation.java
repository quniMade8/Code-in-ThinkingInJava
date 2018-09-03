package parent.enumerated.cartoons;

import net.mindview.util.Generator;

import java.util.Random;

enum CartoonCharactor implements Generator<CartoonCharactor> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random random = new Random(47);

    @Override
    public CartoonCharactor next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharactor cc = CartoonCharactor.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
