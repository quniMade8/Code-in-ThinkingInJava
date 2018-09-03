package parent.demo;

public class Parcel8 {
    public Wrapping getWrapping(int x) {
        return new Wrapping(x) {
            public int value() {
                System.out.println("overrode value()");
                return super.value();
            }
        };
    }

    public static void main(String[] args) {
        System.out.println("x:" + new Parcel8().getWrapping(10).value());
    }
}
