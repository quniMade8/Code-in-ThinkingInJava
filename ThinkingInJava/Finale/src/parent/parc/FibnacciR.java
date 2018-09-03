package parent.parc;

import java.util.Arrays;

public class FibnacciR implements Runnable {
    private int n;
    private int[] fib;

    public int[] getFib() {
        return fib;
    }

    public FibnacciR(int n) {
        n = n < 0 ? 0 : n;
        this.n = n;
        fib = new int[n];
        if (n == 0) {

        } else if (n == 1) {
            fib[0] = 0;
        } else {
            fib[0] = 0;
            fib[1] = 1;
            if (n != 2)
                gen(0, 1);
        }

    }

    private int index = 2;

    private void gen(int i1, int i2) {
        int result = i1 + i2;
        fib[index] = result;
        index++;
        if (index < n) {
            gen(i2, result);
        }
    }

    @Override
    public void run() {
        System.out.println(Arrays.toString(new FibnacciR(20).getFib()));
    }

    public static void main(String[] args) {

    }
}
