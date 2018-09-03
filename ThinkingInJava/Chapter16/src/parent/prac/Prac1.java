package parent.prac;

import parent.util.Countries;

import java.util.*;

public class Prac1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(), list2 = new LinkedList<>();
        list1.addAll(Countries.names(3));
        list2.addAll(Countries.names(11));
        System.out.println(list1);
        System.out.println(list2);
        Collections.shuffle(list1);
        System.out.println(list1);
        Collections.shuffle(list2);
        System.out.println(list2);
    }
}
