package parent.parc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Burger {
    private enum Status {ORIGINAL, CHEESE, PICKLE, MUSHROOM, SAUSAGE}

    private Status status = Status.ORIGINAL;
    private int id;

    public Burger(int id) {
        this.id = id;
    }

    public void cheese() {
        status = Status.CHEESE;
    }

    public void pickle() {
        status = Status.PICKLE;
    }

    public void mushroom() {
        status = Status.MUSHROOM;
    }

    public void sausage() {
        status = Status.SAUSAGE;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Burger(" + id + ") " + status;
    }
}

class BurgerQueue extends LinkedBlockingQueue<Burger> {
}

class BurgerChef implements Runnable {
    private BurgerQueue burgerQueue;
    private int counter;

    public BurgerChef(BurgerQueue burgerQueue) {
        this.burgerQueue = burgerQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Burger b = new Burger(counter++);
                System.out.println(b);
                burgerQueue.put(b);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Cheeser implements Runnable {
    private BurgerQueue burgerQueue;
    private BurgerQueue cheeseBurgerQueue;

    public Cheeser(BurgerQueue burgerQueue, BurgerQueue cheeseBurgerQueue) {
        this.burgerQueue = burgerQueue;
        this.cheeseBurgerQueue = cheeseBurgerQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Burger b = burgerQueue.take(); // Block until get a burger
                b.cheese();
                cheeseBurgerQueue.put(b);
                System.out.println(b);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Prac29 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        BurgerQueue burgerQueue = new BurgerQueue(),
                cheeseBurgerQueue = new BurgerQueue();
        exec.execute(new BurgerChef(burgerQueue));
        exec.execute(new Cheeser(burgerQueue, cheeseBurgerQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
