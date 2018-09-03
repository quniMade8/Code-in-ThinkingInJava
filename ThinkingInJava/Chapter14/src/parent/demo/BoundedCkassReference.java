package parent.demo;

import java.util.ArrayList;

public class BoundedCkassReference {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;

        ArrayList<? extends Number> a = new ArrayList<Integer>();
    }
}
