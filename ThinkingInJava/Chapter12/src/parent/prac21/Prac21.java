package parent.prac21;

class BException extends Exception {
    @Override
    public String toString() {
        return "BException";
    }
}


class BaseClass {
    public BaseClass() throws BException {
        throw new BException();
    }
}

class SubClass extends BaseClass {
    public SubClass() throws BException {
        try {
            //Compile error
            //super();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

public class Prac21 {
    public static void main(String[] args) {

    }
}
