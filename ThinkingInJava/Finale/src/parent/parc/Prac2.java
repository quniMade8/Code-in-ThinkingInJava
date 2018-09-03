package parent.parc;

import java.util.Arrays;

public class Prac2 implements Runnable {
    private int n;
    int[] result;

    public Prac2(int n) {
        this.n = n;
        result = new int[n];
    }

    @Override
    public void run() {
        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < n; i++) {
            result[i] = fib.next();
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Prac2(i)).start();
        }
    }
}
