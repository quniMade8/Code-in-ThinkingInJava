package parent.parc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

class P {

}

class RunBlockingQueue implements Runnable {
    private BlockingQueue<P> queue;

    public RunBlockingQueue(BlockingQueue<P> queue) {
        this.queue = queue;
    }

    public void add(P p) {
        try {
            queue.put(p);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                P p = queue.take();
                System.out.println(p);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Ending run");
    }
}

public class Prac28 {
    public static void main(String[] args) throws InterruptedException, IOException {
        LinkedBlockingDeque<P> queue = new LinkedBlockingDeque<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new RunBlockingQueue(queue));
        exec.shutdown();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            reader.readLine();
            queue.put(new P());
        }
    }
}
