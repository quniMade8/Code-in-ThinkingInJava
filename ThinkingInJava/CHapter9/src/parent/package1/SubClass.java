package parent.package1;

public class SubClass extends SupClass {
    private int i = 10;

    @Override
    public void print() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        new SubClass();
    }
}
