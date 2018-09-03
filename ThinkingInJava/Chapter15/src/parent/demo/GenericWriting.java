package parent.demo;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Furit> fruit = new ArrayList<>();

    static void f() {
        writeExact(apples, new Apple());
        //<thinking in java> p393:error
        //我自己的测试未报错
        writeExact(fruit, new Apple());
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f();
        fruit.add(new Furit());
        fruit.add(new Orange());
        for (Furit x: fruit){
            System.out.println(x);
        }

        //f2();

    }

}
