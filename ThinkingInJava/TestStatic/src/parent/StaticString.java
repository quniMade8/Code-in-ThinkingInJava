package parent;

class AnotherClass {
    AnotherClass() {
        System.out.println("anotherClass");
    }

    void doSth() {
        System.out.println("do sth");
    }
}

public class StaticString {
    private static String str1 = "str1";//1
    private static String str2;
    private AnotherClass c1;
    private AnotherClass c2;

    static {//2s
        //静态初始化
        System.out.println("static initialize");
        str2 = "str1";
    }

    {//5
        // 实例初始化,实例化类时被调用
        System.out.println("static class initialize");
        c1 = new AnotherClass();
    }

    public static void main(String[] args) {
        System.out.println("main()");//4
        System.out.println(str1);
        System.out.println(str2);
        new StaticString();
    }

    static AnotherClass anotherClass = new AnotherClass();//3
}
