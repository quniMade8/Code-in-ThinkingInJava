package parent.demo.containers;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    //散列数组的大小
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<SlowMap.MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<SlowMap.MapEntry<K, V>> bucket = buckets[index];
        SlowMap.MapEntry<K, V> pair = new SlowMap.MapEntry<>(key, value);
        boolean found = false;
        ListIterator<SlowMap.MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            SlowMap.MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (SlowMap.MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<SlowMap.MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (SlowMap.MapEntry<K, V> mPair : bucket)
                set.add(mPair);
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
