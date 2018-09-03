package parent.prac12;

import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>();
        ListIterator<Integer> it1 = list1.listIterator();
        ListIterator<Integer> it2 = list2.listIterator();
        while (it1.hasNext()) {
            int x = it1.next();
            if (it2.hasPrevious()) {
                it2.previous();
            }
            it2.add(x);
        }
        for (int x : list1) {
            System.out.print(x + " ");
            System.out.println();
        }
        for (int x : list2) {
            System.out.print(x + " ");
            System.out.println();
        }

        String str = "calm down,man!guy";
        Stack<String> stack = new Stack<>();
        String[] words = str.split(" ");
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c == ',' || c == '!') {
                    if (!sb.toString().equals("")) {
                        stack.push(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    stack.push(String.valueOf(c));
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                stack.push(sb.toString());
            }
        }
        while (!stack.empty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
