package parent.prac10;

public class Prac10 {
    public static void main(String[] args) {
        char[] x = new char[10];
        System.out.println(x.getClass().getCanonicalName());
        System.out.println(x.getClass().getSuperclass());
        for (Class face : x.getClass().getInterfaces()){
            System.out.println(face);
        }
    }
}
