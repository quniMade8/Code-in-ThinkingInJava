package parent.prac23;

interface U {
    void f1();

    void f2();

    void f3();
}

class A {
    U AF() {
        return new U() {
            @Override
            public void f1() {
                System.out.println("A.f1");
            }

            @Override
            public void f2() {
                System.out.println("A.f2");
            }

            @Override
            public void f3() {
                System.out.println("A.f3");
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}

class B {
    private U[] uList;
    int current = 0;

    public B(int size) {
        uList = new U[size];
    }

    public void add(U u) {
        if (current < uList.length) {
            uList[current] = u;
            current++;
        }
    }

    public void remove(U u) {
        for (int i = 0; i < uList.length; i++) {
            if (uList[i].equals(u)) {
                uList[i] = null;
                return;
            }
        }
    }

    public void print() {
        for (U x : uList) {
            System.out.println(x);
        }
    }

}

public class Prac23 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(10);
        for (int i = 0; i < 10; i++) {
            b.add(a.AF());
        }
        b.print();
    }
}
