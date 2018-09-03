package parent.parc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SyncClass {
    private int intVaule = 0;
    private String stringValue = "String";

    public String getStringValue() {
        return stringValue;
    }

    public synchronized void f() {
        intVaule++;
        stringValue += intVaule;
        Thread.yield();
        stringValue += " String";
    }
}

class SyncThread implements Runnable {
    private SyncClass c;

    public SyncThread(SyncClass c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.f();
            System.out.println(c.getStringValue());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Prac11 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        SyncClass c = new SyncClass();
        for (int i = 0; i < 10; i++) {
            exec.execute(new SyncThread(c));
        }
    }
}
