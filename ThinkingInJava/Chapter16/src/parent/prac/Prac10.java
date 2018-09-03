package parent.prac;

import java.util.*;

class MySortedSet<T extends Comparable<T>> implements Iterable<T> {
    private LinkedList<T> data = new LinkedList<>();
    private Comparator<T> comparator = null;

    public MySortedSet() {

    }

    public MySortedSet(Collection<? extends T> collection) {
        T[] a;
        a = (T[]) collection.toArray();
        if (comparator == null)
            Arrays.sort(a);
        else
            Arrays.sort(a, comparator);
        for (T x : a) {
            if (data.contains(x))
                continue;
            data.add(x);
        }
    }

    public void add(T value) {
        for (int i = 0; i < data.size(); i++) {
            if (comparator != null) {
                if (comparator.compare(value, data.get(i)) < 0 && !data.contains(value)) {
                    data.add(i, value);
                    break;
                }
            } else {
                if (value.compareTo(data.get(i)) < 0 && !data.contains(value)) {
                    data.add(i, value);
                    break;
                }
            }
        }
        if (!data.contains(value)) {
            data.addLast(value);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T x : data) {
            sb.append(x + " ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < data.size() - 1;
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}

public class Prac10 {
    public static void main(String[] args) {
        MySortedSet<Integer> mySortedSet = new MySortedSet<>(Arrays.asList(1, 5, 2, 2, 6, 7, 3, 15));
        mySortedSet.add(0);
        mySortedSet.add(4);
        mySortedSet.add(4);
        mySortedSet.add(10);
        mySortedSet.add(20);
        System.out.println(mySortedSet);


        MySortedSet<String> mySortedSet1 = new MySortedSet<>(Arrays.asList("adam", "max", "django", "elizabeth", "max"));
        mySortedSet1.add("aa");
        mySortedSet1.add("bob");
        mySortedSet1.add("bob");
        mySortedSet1.add("zane");
        mySortedSet1.add("frank");
        mySortedSet1.add("frank");
        System.out.println(mySortedSet1);
    }
}
