package parent.prac28;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Prac28 {
    public static void main(String[] args) {
        Random random = new Random(47);
        Queue queue = new PriorityQueue<Double>();
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextDouble());
        }
        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
