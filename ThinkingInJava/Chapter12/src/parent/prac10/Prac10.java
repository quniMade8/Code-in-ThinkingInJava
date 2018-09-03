package parent.prac10;

import parent.prac3.MyException;

class MyException10 extends Exception {
}

class MyException10_2 extends Exception {
}

class MyClass10 {
    void f() throws MyException10_2 {
        try {
            g();
        } catch (MyException10 e) {
            throw new RuntimeException(e);
        }
    }

    void g() throws MyException10 {
        throw new MyException10();
    }
}

public class Prac10 {
    public static void main(String[] args) {
        MyClass10 x = new MyClass10();
        try {
            x.f();
        } catch (MyException10_2 e) {
            e.printStackTrace(System.out);
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {

        }
    }

}
