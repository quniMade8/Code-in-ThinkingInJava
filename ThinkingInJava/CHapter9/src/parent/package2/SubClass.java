package parent.package2;

public class SubClass extends SupClass {
    public void f1() {
        System.out.println("SubClass.f1()");
    }

    public static SubClass f2(SupClass x) {
        return (SubClass) x;
    }

    public static void main(String[] args) {
        SupClass x = new SubClass();
        SubClass x2 = SubClass.f2(x);

    }

}
