package parent.demo.containers;

public class GroundHog2 extends Groundhog {
    public GroundHog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GroundHog2 && (number == ((GroundHog2) obj).number);
    }
}
