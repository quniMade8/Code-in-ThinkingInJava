package parent.prac4;

import java.util.ArrayList;
import java.util.List;

interface Selector<V> {
    boolean end();

    V current();

    void next();
}

public class Sequence<T> {
    private List<T> items;
    private int next = 0;

    public Sequence(int size) {
        items = new ArrayList<>(size);
    }

    public void add(T item) {
        if (next < items.size()) {
            items.set(next++, item);
        }
    }

    public Selector<T> selector() {
        return new Selector<T>() {
            private int i = 0;

            @Override
            public boolean end() {
                return i == items.size();
            }

            @Override
            public T current() {
                return items.get(i);
            }

            @Override
            public void next() {
                if (i < items.size())
                    i++;
            }
        };
    }

    public static void main(String[] args) {
        Sequence<Integer> s = new Sequence<>(6);
        Selector selector = s.selector();
    }
}
