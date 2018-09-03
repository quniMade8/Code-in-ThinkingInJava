package parent.util;

import java.util.LinkedHashMap;

public class MapData<K, V> extends LinkedHashMap<K, V> {
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> x = gen.next();
            put(x.key, x.value);
        }
    }

    public MapData(Generator<K> kGen, Generator<V> vGen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(kGen.next(), vGen.next());
        }
    }

    public MapData(Generator<K> kGen, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(kGen.next(), value);
        }
    }

    public MapData(Iterable<K> kIter, Generator<V> vGen) {
        for (K x : kIter) {
            put(x, vGen.next());
        }
    }

    public MapData(Iterable<K> kIter, V value) {
        for (K x : kIter) {
            put(x, value);
        }
    }

    //Generic convenience methods:
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<>(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> kGen, Generator<V> vGen, int quantity) {
        return new MapData<>(kGen, vGen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> kGen, V value, int quantity) {
        return new MapData<>(kGen, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> kIter, Generator<V> vGen) {
        return new MapData<>(kIter, vGen);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> kIter, V value) {
        return new MapData<>(kIter, value);
    }
}
