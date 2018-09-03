package parent.demo;

class AClass {
    public AClass() {
    }

    void f() {
        throw new RException();
    }
}

class RException extends RuntimeException {
}

public class TestRuntimeException {
    public static void main(String[] args) {
        AClass x = new AClass();
        x.f();
    }
}
