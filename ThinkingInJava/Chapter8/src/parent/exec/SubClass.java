package parent.exec;

public class SubClass extends AClass {
    @Override
    public void f2() {
        System.out.println("overrode f2");
    }

    public static void main(String[] args) {
        AClass x = new SubClass();
        x.f1();
    }
}
