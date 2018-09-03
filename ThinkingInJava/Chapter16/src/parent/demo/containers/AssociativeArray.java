package parent.demo.containers;

import java.util.HashMap;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(pairs[i][0].toString());
            sb.append(" : ");
            sb.append(pairs[i][1].toString());
            if (i < index - 1)
                sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        AssociativeArray<String, String> map = new AssociativeArray<>(6);
//        map.put("sky", "blue");
//        map.put("she", "green");
//        map.put("ocean", "dancing");
//        map.put("earth", "brown");
//        map.put("tree", "tall");
//        map.put("sun", "warm");
//        try {
//            map.put("extra", "object");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("outOfBounds");
//        }
//        System.out.println(map);
//        System.out.println(map.get("she"));
//        System.out.println(map.get("she").getClass());

        HashMap<String, String> hashMap = new HashMap<>(6);
        hashMap.put("sky", "blue");
        hashMap.put("she", "green");
        hashMap.put("ocean", "dancing");
        hashMap.put("earth", "brown");
        hashMap.put("tree", "tall");
        hashMap.put("sun", "warm");
        System.out.println(hashMap);
        System.out.println(hashMap.get("earth"));
        hashMap.put("moon", "lunatic");
    }

}
