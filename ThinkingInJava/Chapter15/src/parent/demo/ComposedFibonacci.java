package parent.demo;

import java.util.Iterator;

public class ComposedFibonacci implements Iterable<Integer> {
    int n;

    public ComposedFibonacci(int n) {
        this.n = n;
    }

    private Fibonacci f = new Fibonacci();

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return f.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int x : new ComposedFibonacci(20)) {
            System.out.println(x);
        }
    }
}
