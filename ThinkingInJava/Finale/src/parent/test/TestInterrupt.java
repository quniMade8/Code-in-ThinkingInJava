package parent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ThreadToInterrupted implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(1);
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("done");

//        while (!Thread.interrupted()) {
//            System.out.println(1);
//        }
    }
}

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new ThreadToInterrupted());
        TimeUnit.MILLISECONDS.sleep(200);
        //future.cancel(true);
        exec.shutdownNow();
    }
}
