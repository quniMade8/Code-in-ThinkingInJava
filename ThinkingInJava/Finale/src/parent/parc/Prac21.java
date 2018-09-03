package parent.parc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Run1 implements Runnable {
    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Run1 waiting");
                wait();
                System.out.println("Notified from run2");
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
    }

    public synchronized void doNotify() {
        notifyAll();
    }
}

class Run2 implements Runnable {
    private Run1 run1;

    public Run2(Run1 run1) {
        this.run1 = run1;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.SECONDS.sleep(1);
                synchronized (run1) {
                    run1.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Prac21 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Run1 run1 = new Run1();
        exec.execute(run1);
        exec.execute(new Run2(run1));
        exec.shutdown();
    }
}
