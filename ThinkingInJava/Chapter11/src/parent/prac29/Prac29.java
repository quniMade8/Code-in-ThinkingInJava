package parent.prac29;

import java.util.PriorityQueue;
import java.util.Queue;

class MyClass extends Object {

}

public class Prac29 {
    public static void main(String[] args) {
        Queue<MyClass> queue = new PriorityQueue<>();
        queue.offer(new MyClass());
        //java.lang.ClassCastException: parent.prac29.MyClass cannot be cast to java.lang.Comparable
        //queue.offer(new MyClass());
        for (MyClass x : queue) {
            System.out.println(x);
        }
    }
}
