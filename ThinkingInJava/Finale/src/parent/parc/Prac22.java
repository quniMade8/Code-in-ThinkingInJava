package parent.parc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Flag {
    private static boolean flag = false;

    public synchronized boolean getFlag() {
        return flag;
    }

    public synchronized void setTrue() {
        flag = true;
        notifyAll();
    }

    public synchronized void setFalse() {
        flag = false;
    }

    public synchronized void waitForTrue() throws InterruptedException {
        System.out.println("Waiting for True");
        wait();
    }
}

class SetFlagViaWait implements Runnable {
    private Flag flag;

    public SetFlagViaWait(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Setting true");
                flag.setTrue();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
    }
}

class DetectViaWait implements Runnable {
    private Flag flag;

    public DetectViaWait(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                flag.waitForTrue();
                System.out.println("True detected");
                flag.setFalse();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }

    }
}

public class Prac22 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Flag f = new Flag();
        exec.execute(new SetFlagViaWait(f));
        exec.execute(new DetectViaWait(f));
        exec.shutdown();
    }
}
