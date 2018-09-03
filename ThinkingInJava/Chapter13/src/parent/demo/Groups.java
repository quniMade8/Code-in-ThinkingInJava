package parent.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    static public final String POEM =
            "Two brillig, and the slithy toves,\n " +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n";

    public static void main(String[] args) {
//        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
//        System.out.println(m.groupCount());
//        while (m.find()) {
//            System.out.println(m.start());
//            System.out.println(m.group()+" ");
//            System.out.println(m.group(1));
//            System.out.println(m.group(2));
//            System.out.println(m.group(3));
//        }

        //统计不以大写字母开头的单词，并不重复地计数
        Map<String, Integer> map = new HashMap<String, Integer>();
        Matcher m = Pattern.compile("(\\s)([a-z]+)").matcher(POEM);
        while (m.find()) {
            System.out.println(m.group(2));
            String key = m.group(2);
            if (!map.containsKey(m.group(2))) {
                map.put(key, 1);
            } else {
                int value = map.get(key);
                map.put(key, ++value);
            }
        }

        for (String k : map.keySet()) {
            System.out.println(k + " : " + map.get(k));
        }
    }
}
