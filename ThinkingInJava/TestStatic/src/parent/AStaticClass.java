package parent;

class AClass {
    public static String str = "static STRING";

    AClass() {

    }

    public String getStr() {
        return str;
    }
}

public class AStaticClass {
    public static void main(String[] args) {
        AClass var = new AClass();
        AClass.str = "edited";
        System.out.println(var.getStr());
        AClass var2 = new AClass();
        System.out.println(var2.getStr());
    }
}
