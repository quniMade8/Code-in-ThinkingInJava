package parent.demo;

import parent.Prac38.Coffee;
import parent.util.SimpleQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T> {
    void add(T x);
}

public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T x) {
        c.add(x);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T x) {
        super.add(x);
    }
}

class Latte extends Coffee {
}

class Fill2Test {
    public static void main(String[] args) {
        //Adapt a collection:
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for (Coffee c : carrier) {
            System.out.println(c);
        }
        System.out.println("--------------");

        AddableSimpleQueue<Coffee> coffees = new AddableSimpleQueue<>();
        Fill2.fill(coffees, Latte.class, 5);
        for (Coffee x : coffees) {
            System.out.println(x);
        }
    }
}

