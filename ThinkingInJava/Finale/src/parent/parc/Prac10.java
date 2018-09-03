package parent.parc;

import java.util.concurrent.*;

public class Prac10 {
    private String name;

    public Prac10(String name) {
        this.name = name;
    }

    public Future<Long> runTask(final int count) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Long> result = exec.submit(new Callable<Long>() {
            int c = count;
            Fibonacci fib = new Fibonacci();

            @Override
            public Long call() throws Exception {
                long sum = 0;
                while (c-- > 0) {
                    sum += fib.next();
                }
                return sum;
            }
        });
        exec.shutdown();
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long> result = new Prac10("fib1").runTask(10);
        System.out.println(result.get());
    }
}
