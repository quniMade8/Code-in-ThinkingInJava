package parent.temp;

public class Outer {
    public static class Inner {
        public Inner() {
        }
    }

    public static final Inner x = new Inner();

    public static void main(String[] args) {
        Outer.Inner x = new Inner();

    }
}
