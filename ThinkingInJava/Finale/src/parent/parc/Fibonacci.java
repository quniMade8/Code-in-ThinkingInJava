package parent.parc;

public class Fibonacci implements Generator<Integer> {
    private int i1 = 0, i2 = 1;
    private int index = 0;
    private int current = 0;

    @Override
    public Integer next() {
        if (index == 0) {
            index++;
            return 0;
        }
        if (index == 1) {
            index++;
            return 1;
        }
        current = i1 + i2;
        i1 = i2;
        i2 = current;
        index++;
        return current;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.println(fib.next());
        }
    }
}
