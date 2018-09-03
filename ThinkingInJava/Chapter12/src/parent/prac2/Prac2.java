package parent.prac2;

public class Prac2 {
    public static void main(String[] args) {
        Object o = null;
        try {
            System.out.println(o.toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.err.println("Error");
        }

    }
}
