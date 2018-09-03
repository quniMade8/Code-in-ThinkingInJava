package parent.prac;


import net.mindview.util.TextFile;

import java.util.HashMap;
import java.util.Map;

public class Prac17 {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        TextFile text = new TextFile("test.txt", "\\W+");
        for (String s : text) {
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    int oldValue = map.get(c);
                    map.put(c, ++oldValue);
                } else {
                    map.put(c, 1);
                }
            }
        }
        for (char key : map.keySet())
            System.out.println(key + ": " + map.get(key) + "\n");
    }
}
