package parent.prac15;

class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class TestTuple {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("first", 1);
    }

    static TwoTuple f2() {
        return new TwoTuple("ha", 1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> t = TestTuple.f2();
        System.out.println(t);
    }
}
