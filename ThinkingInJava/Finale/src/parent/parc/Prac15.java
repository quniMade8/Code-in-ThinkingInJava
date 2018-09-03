package parent.parc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MultiSynch {
    String syncStr = "MultiSynch.syncStr";
    private Lock lock = new ReentrantLock();

    public void f() {
        synchronized (syncStr) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
    }

    public void g() {
        synchronized (syncStr) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public void h() {
        synchronized (syncStr) {
            for (int i = 0; i < 5; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        }
    }
}

public class Prac15 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        MultiSynch ms = new MultiSynch();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                ms.f();
            }
        });
        exec.execute(new Runnable() {
            @Override
            public void run() {
                ms.g();
            }
        });
        exec.execute(new Runnable() {
            @Override
            public void run() {
                ms.h();
            }
        });
        exec.shutdown();
    }
}
