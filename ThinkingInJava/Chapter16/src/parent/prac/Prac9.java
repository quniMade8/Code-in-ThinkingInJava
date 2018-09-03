package parent.prac;

import parent.util.CountingGenerator;
import parent.util.Generator;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}


public class Prac9 {
    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<String>(new MyComparator());
        Generator<String> generator = new CountingGenerator.String();
        for (int i = 0; i < 7; i++) {
            set.add(generator.next());
        }
        System.out.println(set);
    }
}
