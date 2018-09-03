package parent.prac32;

import java.util.Iterator;

public class MultiIterableClass implements Iterable<Integer> {
    private int[] array;
    private int index = 0;
    private int rIndex;

    public MultiIterableClass(int... args) {
        array = new int[args.length];
        int i = 0;
        for (int x : args) {
            array[i++] = x;
        }
        rIndex = array.length - 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                return array[index++];
            }
        };
    }

    public Iterable<Integer> reversedIterator() {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    @Override
                    public boolean hasNext() {
                        return rIndex > -1;
                    }

                    @Override
                    public Integer next() {
                        return array[rIndex--];
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mc = new MultiIterableClass(1, 2, 3);
        for (int x : mc.reversedIterator()) {
            x++;
            System.out.println(x);
        }
        for (int x : mc) {
            System.out.println(x);
        }
    }
}
