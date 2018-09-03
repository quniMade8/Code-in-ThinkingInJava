package parent.test;

import parent.parc.Fibonacci;

import java.util.concurrent.*;

class CallMe implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Fibonacci f = new Fibonacci();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += f.next();
        }
        return sum;
    }
}

public class testCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> future = exec.submit(new CallMe());
        exec.shutdown();
        System.out.println(future.get());
    }
}
