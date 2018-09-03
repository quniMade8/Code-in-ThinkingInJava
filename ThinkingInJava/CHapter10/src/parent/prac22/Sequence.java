package parent.prac22;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object items[];
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    private class ReverseSelector implements Selector {
        private int i = items.length - 1;

        @Override
        public boolean end() {
            return i == -1;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i > -1) i--;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSelector();
    }

    public Selector anonymousReverseSelecotr() {
        return new Selector() {
            private int i = items.length - 1;

            @Override
            public boolean end() {
                return i == -1;
            }

            @Override
            public Object current() {
                return items[i];
            }

            @Override
            public void next() {
                if (i > -1) i--;
            }
        };
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        Selector rSelector = sequence.anonymousReverseSelecotr();
        while (!rSelector.end()) {
            System.out.print(rSelector.current() + " ");
            rSelector.next();
        }

    }

}
