package parent.demo;

import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> c, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            c.add(gen.next());
        }
        return c;
    }
}
