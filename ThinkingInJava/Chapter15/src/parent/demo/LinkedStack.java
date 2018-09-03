package parent.demo;

public class LinkedStack<T> {
    private static class Node<T> {
        T item;
        Node<T> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null & next == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        for (String x : "Who is your daddy?".split(" ")) {
            stack.push(x);
        }
        while (!stack.top.end()) {
            System.out.println(stack.pop());
        }
    }
}
