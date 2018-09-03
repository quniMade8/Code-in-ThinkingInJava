package parent.util;

import java.util.*;

public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        this.size = size < 0 ? 0 : size;
    }

    private static class Entry implements Map.Entry<Integer, String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            return Integer.valueOf(index).equals(obj);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }

        @Override
        public String toString() {
            return this.index + "" + getValue();
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
        private int size;

        public EntrySet(int size) {
            if (size < 0)
                this.size = 0;
            else if (size > chars.length)
                this.size = chars.length;
            else
                this.size = size;
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    entry.index++;
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return new EntrySet(chars.length);
    }

    static Set<Map.Entry<Integer, String>> select(int size) {
        return new EntrySet(size);
    }

    public static void main(String[] args) {
        System.out.println(select(5));
    }
}
