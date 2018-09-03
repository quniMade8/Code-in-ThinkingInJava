package parent.parc;

class Task1 implements Runnable {
    private static int counter = 0;
    private int id = counter++;

    private String beginMsg, endMsg;


    public Task1(String beginMsg, String endMsg) {
        this.beginMsg = beginMsg;
        this.endMsg = endMsg;
    }

    @Override
    public void run() {
        System.out.println("run task1: " + id);
        Thread.yield();
        System.out.println("run task1: " + id);
        Thread.yield();
        System.out.println("run task1: " + id);
        Thread.yield();
        return;
    }
}

public class Prac1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Task1("begin","end")).start();
        }
    }
}
