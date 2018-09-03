package parent.test;

import java.util.ArrayList;

class Temp<T> {
    private Object x;

    public Temp(Object x) {
        this.x = x;
    }

    T get() {
        return (T) x;
    }
}

public class TestGenerics {
    public static void main(String[] args) {
        Temp<ArrayList> x = new Temp<>(new ArrayList());
        System.out.println(x.get().getClass());
    }
}
