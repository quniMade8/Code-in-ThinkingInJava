package parent.prac8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prac8 {
    private static final String sentence = "Java now has regular expression";
    private static List<String> regexs = new ArrayList<String>(Arrays.asList(
            "^Java",
            "\\Breg.*",
            "n.w\\s+h(a|i)s",
            "s?",
            "s*",
            "s+",
            "s{4}",
            "s{1}",
            "s{0,3}"));

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(Java).+");
        Matcher m = p.matcher(sentence);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());
        System.out.println(m.group(1));
    }
}
