package parent.demo.containers;

import parent.util.Countries;

import java.util.*;

public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    static class MapEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private final V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode() ^ (value == null ? 0 : value.hashCode()));
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MapEntry)) return false;
            MapEntry me = (MapEntry) obj;
            return
                    (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                            (value == null ? me.getValue() == null : value.equals(me.getValue()));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry(ki.next(), vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals());
        System.out.println(m);
        System.out.println(m.get("CHINA"));
        System.out.println(m.entrySet());
    }
}
