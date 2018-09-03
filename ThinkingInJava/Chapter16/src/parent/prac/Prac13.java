package parent.prac;

import parent.demo.containers.AssociativeArray;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prac13 {
    public static void main(String[] args) {
        String words = "Can't tell your mama,\n" +
                "She'd only tell you\n" +
                "That she told you so,\n" +
                "The life you are leading\n" +
                "She won't believe\n" +
                "The real trick of life\n" +
                "we all know.";
        AssociativeArray<String, Integer> map = new AssociativeArray<>(65536);
        Matcher matcher = Pattern.compile("\\w+").matcher(words);
        while (matcher.find()) {
            String key = matcher.group();
            if (map.get(key) == null)
                map.put(key, 1);
            else {
                int count = map.get(key);
                map.put(key, ++count);
            }
        }
        System.out.println(map);
    }
}
