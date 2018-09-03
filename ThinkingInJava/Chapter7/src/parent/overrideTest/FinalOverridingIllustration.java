package parent.overrideTest;

class WithFinals {
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    private void g() {
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private final void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    public final void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllustration {
    public static void main(String[] args) {
        OverridingPrivate2 x = new OverridingPrivate2();
        x.f();
        x.g();
        OverridingPrivate x2 = x;

    }
}
