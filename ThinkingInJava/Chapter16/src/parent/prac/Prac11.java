package parent.prac;

import java.util.PriorityQueue;

class IntegerItem implements Comparable<IntegerItem> {
    private Integer item;

    public IntegerItem(Integer item) {
        this.item = item;
    }

    @Override
    public int compareTo(IntegerItem o) {
        if (item > o.item)
            return +1;
        else if (item.equals(o.item))
            return 0;
        return -1;
    }

    @Override
    public String toString() {
        return Integer.toString(item);
    }
}

public class Prac11 {
    public static void main(String[] args) {
        PriorityQueue<IntegerItem> q = new PriorityQueue<>();
        q.add(new IntegerItem(8));
        q.add(new IntegerItem(2));
        q.add(new IntegerItem(3));
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
