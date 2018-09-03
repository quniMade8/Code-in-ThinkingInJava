package parent.prac4;

import java.util.*;

public class FilmGenerator {
    private static final String name = "Fantastic Mr. Fox";
    private int i = 0;

    public char next() {
        if (i >= name.length()) {
            i = 0;
        }
        return name.toCharArray()[i++];
    }

    public static void main(String[] args) {
        FilmGenerator x = new FilmGenerator();
        Collection c1 = new ArrayList();
        Collection c2 = new LinkedList();
        Collection c3 = new HashSet();
        Collection c4 = new TreeSet();
        Collection c5 = new LinkedHashSet();

        for (int i = 0; i < 10; i++) {
            c1.add(x.next());
        }
        for (int i = 0; i < 10; i++) {
            c2.add(x.next());
        }
        for (int i = 0; i < 10; i++) {
            c3.add(x.next());
        }
        for (int i = 0; i < 10; i++) {
            c4.add(x.next());
        }
        for (int i = 0; i < 10; i++) {
            c5.add(x.next());
        }



    }
}
