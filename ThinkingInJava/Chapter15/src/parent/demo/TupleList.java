package parent.demo;

import parent.prac3.FourTuple;

import java.util.ArrayList;

public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Integer, String, Character, Boolean> t1 = new TupleList<>();
        t1.add(new FourTuple<>(1, "1", '1', false));
        t1.add(new FourTuple<>(2, "2", '3', true));

    }
}
