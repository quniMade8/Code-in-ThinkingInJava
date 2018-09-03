package parent.prac30;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionsSequence extends AbstractCollection<Pet> {
    private Pet[] pets = {new Pet(), new Pet(), new Pet()};

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionsSequence c = new CollectionsSequence();
        for (Pet x : c) {
            System.out.println(x);
        }
        Iterator<Pet> it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
