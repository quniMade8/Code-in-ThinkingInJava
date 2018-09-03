package parent.enumerated;

import static net.mindview.util.Print.*;

enum Shrubbery {GROUND, CRAWLING, HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());
            print(s.compareTo(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("----------------");
        }
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery sh = Enum.valueOf(Shrubbery.class, s);
            print(sh);
        }
    }
}
