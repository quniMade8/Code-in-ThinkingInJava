package parent.prac17;

import java.util.Random;

interface type {
    void generate();
}

interface typeFactory {
    type getType();
}

class Dice implements type {
    public static typeFactory factory = new typeFactory() {
        @Override
        public type getType() {
            return new Dice();
        }
    };

    private Random random = new Random();

    @Override
    public void generate() {
        int result = random.nextInt(6) + 1;
        System.out.println("Dice : " + result);
    }

}

class Coin implements type {
    public static typeFactory factory = new typeFactory() {
        @Override
        public type getType() {
            return new Coin();
        }
    };
    private Random random = new Random();

    @Override
    public void generate() {
        String result = random.nextBoolean() ? "head" : "tail";
        System.out.println("Coin : " + result);
    }
}


public class RandomFactory {
    public static void factoryConsumer(typeFactory factory) {
        type x = factory.getType();
        x.generate();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            RandomFactory.factoryConsumer(Coin.factory);
        }
        for (int i = 0; i < 10; i++) {
            RandomFactory.factoryConsumer(Dice.factory);
        }
    }
}
