package parent.prac;

import parent.util.CountingGenerator;
import parent.util.Generator;

import java.util.*;

class DoubleString implements Comparable<DoubleString> {
    private static int counter;
    private final int id = counter++;
    private String str1;
    private String str2;

    public DoubleString(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public int compareTo(DoubleString o) {
        if (o == null)
            return 1;
        return str1.compareTo(o.str1);
    }

    @Override
    public String toString() {
        return "str1:" + str1 + " str2:" + str2;
    }

    @Override
    public int hashCode() {
        int result = 17;
        //result = result * 37 + id;
        result = result * 37 + str1.hashCode();
        result = result * 37 + str2.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DoubleString && ((DoubleString) obj).str1.equals(str1) && ((DoubleString) obj).str2.equals(str2);
        //return obj instanceof DoubleString && ((DoubleString) obj).id == id;
    }
}

public class Prac40 {
    public static void main(String[] args) {
//        List<DoubleString> list = new ArrayList<>();
//        Generator<String> generator = new CountingGenerator.String();
//        for (int i = 0; i < 20; i++) {
//            list.add(new DoubleString(generator.next(), generator.next()));
//        }
//        Collections.shuffle(list);
//        System.out.println("Shuffled list");
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println("Sorted list");
//        System.out.println(list);
//        int index = Collections.binarySearch(list, new DoubleString("ERTYUIO", "PLKJHGF"));
//        System.out.println(index);
        Set<DoubleString> set = new HashSet<>();
        //这两个对象的hashcode相同，hash到相同的bucket，但是不equal
        //hash到相同的槽位，并且equal才能算重复的对象
        set.add(new DoubleString("a", "b"));
        set.add(new DoubleString("b", "a"));
        set.add(new DoubleString("a", "b"));
        System.out.println(set);

    }
}
