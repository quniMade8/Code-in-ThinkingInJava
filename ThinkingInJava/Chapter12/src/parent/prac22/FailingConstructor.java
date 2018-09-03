package parent.prac22;

class DestoryableClass {
    public DestoryableClass() {
    }
}

class FException extends Exception {
    @Override
    public String toString() {
        return "FException";
    }
}

public class FailingConstructor {
    DestoryableClass dc;

    public FailingConstructor() throws FException {
        dc = new DestoryableClass();
        throw new FException();
    }

    void f() {
    }

    void dispose() {
    }

    public static void main(String[] args) {
        try {
            FailingConstructor x = new FailingConstructor();
            try {
                x.f();
            } catch (Exception e) {
                System.out.println("Exception in x.f()");
            } finally {
                x.dispose();
            }
        } catch (Exception e) {
            System.out.println("Constructor Failed");
        }
    }
}

