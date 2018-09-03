package parent.demo;

public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;

            public int value() {
                return i;
            }
        };
    }

    private class Contents {
    }
}
