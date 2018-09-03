package parent.demo;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Furit> fruit = Arrays.asList(new Furit());

    static void f() {
        Apple a = readExact(apples);
        Furit f = readExact(fruit);
        f = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Furit> furitReader = new Reader<>();
        Furit f = furitReader.readExact(fruit);
        //furitReader.readExact(apples);
    }

    static class CovariantReader<T> {
        T readCibvaruabt(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Furit> furitCovariantReader = new CovariantReader<>();
        Furit f = furitCovariantReader.readCibvaruabt(fruit);
        Furit a = furitCovariantReader.readCibvaruabt(apples);
    }

    public static void main(String[] args) {
        f();
        f2();
        f3();
    }
}
