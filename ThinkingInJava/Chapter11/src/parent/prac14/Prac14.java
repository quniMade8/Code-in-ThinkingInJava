package parent.prac14;

import java.util.*;

public class Prac14 {
    public static void main(String[] args) {
        Random r = new Random(47);
        List<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(11, 11, 11, 11, 11, 11, 11, 11, 11, 11));
        ListIterator<Integer> it;
        int[] ints = new int[5];
        for (int i = 0; i < 5; i++) {
            ints[i] = r.nextInt(10);
        }
        for (int x : ints) {
            it = list.listIterator(list.size() / 2);
            it.add(x);
        }
        for (Integer x : list) {
            System.out.print(x + " ");
        }
    }
}
