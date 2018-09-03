package parent.test;

class StaticClass {
    public static int staticInt = 0;

    public static void printSth() {
        System.out.println("static method");
    }
}

class SubClass extends StaticClass {
    public static void printSth() {
        System.out.println("new print");
    }
}

public class TestStatic {
    public static void main(String[] args) {
        StaticClass.staticInt = 1;
        SubClass.staticInt = 2;
        System.out.println(StaticClass.staticInt);
        System.out.println(SubClass.staticInt);
        SubClass.printSth();
        StaticClass.printSth();
    }
}
