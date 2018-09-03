package parent.parc;

import java.util.ArrayList;
import java.util.concurrent.*;

class FibnacciC implements Callable<Long> {
    private int n;

    public FibnacciC(int n) {
        this.n = n < 0 ? 0 : n;
    }

    @Override
    public Long call() throws Exception {
        Fibonacci fib = new Fibonacci();
        long sum = 0;
        while (n-- > 0) {
            sum += fib.next();
        }
        return sum;
    }
}

public class Prac5 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            futures.add(exec.submit(new FibnacciC(i)));
        }
        exec.shutdown();
        for (Future<Long> x : futures)
            System.out.print(x.get() + " ");
    }
}
