package parent.prac12;

public class TheClass {
    private int var;

    private void f1() {
        System.out.println("TheClass.f1()");
    }

    class InnerClass {
        private void callOuterClass() {
            var = 10;
            System.out.println("var:" + var);
            f1();
        }
    }

    public void call() {
        InnerClass x = new InnerClass();
        x.callOuterClass();
    }

    public static void main(String[] args) {
        new TheClass().call();
    }
}
