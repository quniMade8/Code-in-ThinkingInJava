package parent.parc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Product {
    private static volatile int count = 0;

    @Override
    public String toString() {
        return "Product: " + count;
    }

    synchronized void increaseOne() {
        count++;
        System.out.println("Produced one " + this);
    }

    synchronized void decreaseOne() {
        count--;
        System.out.println("Consumed one " + this);
    }

    synchronized int getCount() {
        return count;
    }
}

class Producer implements Runnable {
    private final Store store;
    public boolean isSuspended = false;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (store.product.getCount() > 9) {
                        // 生产了过多的商品就停下
                        store.producer.isSuspended = true;
                        wait();
                    }
                }
                TimeUnit.MILLISECONDS.sleep(100);
                store.product.increaseOne();
                if (store.comsumer.isSuspended) {
                    synchronized (store.comsumer) {
                        store.comsumer.isSuspended = false;
                        store.comsumer.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final Store store;
    public boolean isSuspended = false;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (store.product.getCount() < 1) {
                        store.comsumer.isSuspended = true;
                        // 如果没有商品可以被消费
                        wait();
                    }
                }
                TimeUnit.MILLISECONDS.sleep(200);
                store.product.decreaseOne();
                if (store.producer.isSuspended) {
                    synchronized (store.producer) {
                        store.producer.isSuspended = false;
                        store.producer.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Store {
    public Producer producer = new Producer(this);
    public Consumer comsumer = new Consumer(this);
    public Product product = new Product();
    public ExecutorService exec = Executors.newCachedThreadPool();

    public Store() {
        exec.execute(producer);
        exec.execute(comsumer);
    }
}

public class Prac24 {
    public static void main(String[] args) {
        new Store();
    }
}
