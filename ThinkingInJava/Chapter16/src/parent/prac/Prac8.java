package parent.prac;

import parent.util.Countries;

import java.util.Collection;


class SList<T> {
    final Link<T> head;

    public SList() {
        this.head = new Link<>(null);
    }

    public SList(T head) {
        this.head = new Link<>(head);
    }

    public SList(Collection<? extends T> collection) {
        java.util.Iterator<? extends T> iterator = collection.iterator();
        if (iterator.hasNext()) {
            head = new Link<>(iterator.next());
        } else {
            head = new Link<>(null);
            return;
        }
        Link<T> n = head;
        while (iterator.hasNext()) {
            Link<T> newLink = new Link<>(iterator.next());
            n.nextLink = newLink;
            n = newLink;
        }
    }

    class Link<T> {
        public Link(T value) {
            this.value = value;
        }

        T value;
        Link<T> nextLink = null;

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public class Iterator {
        Link<T> current = head;

        public Iterator() {
        }

        public Iterator(int start) {
            while (start-- != 0)
                current = current.nextLink;
        }

        public boolean hasNext() {
            return current.nextLink != null;
        }

        public Link<T> current() {
            return current;
        }

        public Link<T> next() {
            current = current.nextLink;
            return current;
        }

        public void add(T value) {
            Link<T> x = new Link<>(value);
            Link<T> next = current.nextLink;
            current.nextLink = x;
            x.nextLink = next;
            next();
        }

        public void jumpToHead() {
            current = head;
        }

        public void remove() {
            if (current == null)
                return;
            T currentValue = current.value;
            jumpToHead();
            while (current.nextLink.value != currentValue) {
                current = current.nextLink;
            }
            if (current.nextLink.nextLink == null) {
                current.nextLink = null;
                return;
            }
            current.nextLink = current.nextLink.nextLink;
            next();
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }

    public Iterator iterator(int start) {
        return new Iterator(start);
    }
}

public class Prac8 {
    public static void main(String[] args) {
        SList<String> sList = new SList<>(Countries.names());
        SList.Iterator iterator = sList.iterator();
        System.out.print(iterator.current + " ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        iterator.jumpToHead();
        iterator.next();
        iterator.add("COLUMBIA");
        iterator.next();
        iterator.next();
        iterator.remove();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.remove();

        iterator.jumpToHead();
        System.out.print(iterator.current + " ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
