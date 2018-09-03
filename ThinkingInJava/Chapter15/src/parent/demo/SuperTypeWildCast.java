package parent.demo;

import java.util.List;

public class SuperTypeWildCast {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Fuji());
        apples.add(new Apple());
        //apples.add(new Orange()); //error
        //apples.add(new Furit()); //error
    }
}
