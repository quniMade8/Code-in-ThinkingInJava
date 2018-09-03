package parent.prac25;

interface A {
    void a();
}

interface B {
    void b();
}

class Impl implements A, B {
    <T extends A> void f(T x) {
        x.a();
    }

    <T extends B> void g(T x) {
        x.b();
    }

    @Override
    public void a() {
        System.out.println("a");
    }

    @Override
    public void b() {
        System.out.println("b");
    }
}

public class Prac25 {
    public static void main(String[] args) {
        new Impl().f(new Impl());
        new Impl().g(new Impl());
    }
}
