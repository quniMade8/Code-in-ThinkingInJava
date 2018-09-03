package parent.parc;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Prac14 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            System.out.println("run a task");
                        }
                    }, 5000);
                }
            }
        });
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, 10000);
    }
}
