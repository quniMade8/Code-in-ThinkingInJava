package parent.prac;

import parent.util.Countries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Prac7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Countries.names()).subList(0, 4);
        List<String> linkedlist = new LinkedList<>(Countries.names()).subList(4, 8);
        System.out.println(list);
        System.out.println(linkedlist);
        ListIterator<String> listIterator = list.listIterator();
        ListIterator<String> listIterator2 = linkedlist.listIterator();
//        while (listIterator.hasNext()) {
//            listIterator.next();
//            if (listIterator2.hasNext()) {
//                listIterator.add(listIterator2.next());
//            }
//        }
        ListIterator<String> preIter = list.listIterator(list.size());
        ListIterator<String> preLIter = linkedlist.listIterator(linkedlist.size());
        while (preIter.hasPrevious()) {
            preIter.previous();
            if (preLIter.hasPrevious()) {
                preIter.add(preLIter.previous());
            }
            preIter.previous();
        }
        System.out.println(list);
    }
}
