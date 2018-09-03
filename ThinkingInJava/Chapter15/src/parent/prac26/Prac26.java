package parent.prac26;

import java.util.ArrayList;
import java.util.List;

public class Prac26 {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
        //list.add(1);
        Number[] n = new Integer[10];
        n[0] = 1;
        n[1] = new Double(1);
    }
}
