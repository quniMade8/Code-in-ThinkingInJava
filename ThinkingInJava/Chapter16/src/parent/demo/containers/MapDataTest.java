package parent.demo.containers;

import parent.util.CountingGenerator;
import parent.util.Generator;
import parent.util.MapData;
import parent.util.Pair;

import java.util.Iterator;

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));
        System.out.println(MapData.map(new CountingGenerator.Character(), new CountingGenerator.String(), 3));
    }
}
