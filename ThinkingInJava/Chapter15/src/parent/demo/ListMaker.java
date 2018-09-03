package parent.demo;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> lm = new ListMaker<>();
        List<String> list = lm.create();
    }
}
