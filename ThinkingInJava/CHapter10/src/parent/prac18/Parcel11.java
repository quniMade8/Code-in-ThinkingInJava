package parent.prac18;

public class Parcel11 {
    private static class ParcelContent {
        private int i = 11;

        public int value() {
            return i;
        }

        private static class InnerParcelContent {
            private int x = 2;
        }
    }

    class InnerClass {
        void f1() {
            System.out.println("f1");
        }
    }

    public static void main(String[] args) {
        ParcelContent x = new ParcelContent();
        System.out.println(x.value());

        //InnerClass x2 = new InnerClass();

        Parcel11 p = new Parcel11();
        Parcel11.InnerClass x2 = p.new InnerClass();
    }
}
