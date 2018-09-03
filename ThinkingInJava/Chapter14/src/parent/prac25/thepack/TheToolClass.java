package parent.prac25.thepack;

public class TheToolClass {
    private String name;
    protected Long id;

    protected String name() {
        return name;
    }

    private String nameAndId() {
        return id + name;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
