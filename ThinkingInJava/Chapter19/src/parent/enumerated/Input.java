package parent.enumerated;

import java.util.Random;

public enum Input {
    //输入集合
    NICKEL(5), DIME(10), QUATOR(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {//Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;

    Input() {
    }

    Input(int value) {
        this.value = value;
    }

    int amount() {
        return value;
    }

    static Random rand = new Random(47);

    public static Input randomSelection() {
        return values()[rand.nextInt(values().length - 1)];
    }

}
