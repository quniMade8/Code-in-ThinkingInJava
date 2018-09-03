package parent.parc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sleepy implements Runnable {
    private Random rand = new Random(47);

    @Override
    public void run() {
        try {
            Date date = new Date();
            long o = date.getTime();
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
            long n = new Date().getTime();
            System.out.println("睡眠: " + (n - o));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Prac6 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Sleepy());
        }
        exec.shutdown();
    }
}
