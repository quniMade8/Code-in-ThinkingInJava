package parent.parc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Prac3 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            exec.execute(new Prac2(i));
        }
        exec.shutdown();
    }
}
