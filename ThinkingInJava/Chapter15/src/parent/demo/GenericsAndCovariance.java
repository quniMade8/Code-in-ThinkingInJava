package parent.demo;

import java.util.ArrayList;
import java.util.List;

class Furit {
}

class Apple extends Furit {
}

class Fuji extends Apple {
}

class Orange extends Furit {
}

public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Furit> furits = new ArrayList<Apple>();

        //wouldn't compile
        //furits.add(new Apple());
        //furits.add(new Furit());
    }
}
