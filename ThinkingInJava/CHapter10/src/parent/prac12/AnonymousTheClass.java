package parent.prac12;

public class AnonymousTheClass {
    class InnerClass {
        void callOuterClass(){
            var = 1;
            System.out.println("var:" + var);
        }
    }

    private int var;

    private void f1() {
        System.out.println("TheClass.f1()");
    }

    public InnerClass call() {
        return new InnerClass() {
            @Override
            public void callOuterClass() {
                System.out.println("overrode callOuterClass()");
                var = 20;
                System.out.println("var:" + var);
            }
        };
    }

    public static void main(String[] args) {
        new AnonymousTheClass().call().callOuterClass();
    }
}
