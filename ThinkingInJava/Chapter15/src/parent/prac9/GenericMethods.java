package parent.prac9;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class GenericMethods<T> {
    public static <A, B, C> void f(A a, B b, C c, char d) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static void main(String[] args) {
        GenericMethods.f(1, "shit", new ArrayList<>(), 'd');
    }
}
