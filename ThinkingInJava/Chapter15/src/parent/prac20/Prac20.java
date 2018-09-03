package parent.prac20;

interface TheInterface {
    void f();

    void g();
}

class TheImpl implements TheInterface {

    @Override
    public void f() {
        System.out.println("f");
    }

    @Override
    public void g() {
        System.out.println("g");
    }

    public void h() {
        System.out.println("h");
    }

    public <T extends TheInterface> void t(T t) {
        t.f();
        t.g();
    }
}

public class Prac20 {
    public static void main(String[] args) {
        new TheImpl().t(new TheImpl());

    }
}
