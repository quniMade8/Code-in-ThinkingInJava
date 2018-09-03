package parent.prac;

import parent.util.Countries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prac2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Map<String, String> m = Countries.capitals();
        Map<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String, String> e : m.entrySet()) {
            if (e.getKey().startsWith("A")) {
                resultMap.put(e.getKey(), e.getValue());
                set.add(e.getKey());
            }
        }
        System.out.println(resultMap);
        System.out.println(set);
    }
}
