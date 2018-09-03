package parent.prac3;

public class CatchMyException {
    public void f() throws MyException {
        throw new MyException("haha");
    }

    public static void main(String[] args) {
        CatchMyException c = new CatchMyException();
        boolean token = true;
        long counter = 1;
        //打印好像有线程同步问题
        while (token) {
            System.out.println("Loop : " + counter++);
            try {
                c.f();
                token = false;
            } catch (MyException e) {
                //e.printInfo();
                //e.printStackTrace();
            } finally {
                if (counter > 20) {
                    token = false;
                }
            }
        }
    }
}
