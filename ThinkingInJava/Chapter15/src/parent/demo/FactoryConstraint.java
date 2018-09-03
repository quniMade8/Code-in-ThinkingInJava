package parent.demo;

interface Factory<T> {
    T create();
}

class StringFactory implements Factory<String> {
    @Override
    public String create() {
        return new String();
    }
}

class InstantizeGenericType<T> {
    private T x;

    public <F extends Factory<T>> InstantizeGenericType(F factory) {
        x = factory.create();
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new InstantizeGenericType<>(new StringFactory());
    }
}
