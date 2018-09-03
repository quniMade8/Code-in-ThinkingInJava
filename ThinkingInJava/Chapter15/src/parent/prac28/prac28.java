package parent.prac28;

import java.util.Arrays;
import java.util.List;

class Pet {
}

class Cat extends Pet {
}

class Hasky extends Dog {
}

class Dog extends Pet {
}

class Generic1<T> {
    public void f(T x) {

    }
}

class Generic2<T> {
    public T f(List<? extends T> x) {
        return x.get(0);
    }
}

public class prac28 {
    public void f1(Generic1<? super Dog> x) {
        x.f(new Hasky());
    }

    public void f2(Generic2<Pet> x) {
        x.f(Arrays.asList(new Dog()));
    }
}
