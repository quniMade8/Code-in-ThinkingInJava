package parent.demo;

import java.util.ArrayList;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <V> Generator<V> create(Class<V> type) {
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) {
        BasicGenerator.create(ArrayList.class);
    }
}
