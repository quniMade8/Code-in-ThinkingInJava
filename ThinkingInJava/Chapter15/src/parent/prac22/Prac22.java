package parent.prac22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class X {
    public X(String s) {
        System.out.println(s);
    }

    void f(int i) {
        System.out.println("f " + i);
    }
}

class Y<T> {
    public T x;

    public Y(Class<T> type, String s) {
        try {
            Constructor<T> c = type.getDeclaredConstructor(String.class);
            x = c.newInstance(s);
            Method m = type.getDeclaredMethod("f", int.class);
            m.invoke(x, 1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

public class Prac22 {
    public static void main(String[] args) {
        Y<X> x = new Y<>(X.class, "a");

    }
}
