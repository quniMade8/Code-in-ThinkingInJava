package parent.demo.typeinfo.pets;

public class Individual {
    private static long counter = 0;
    private long id = counter++;
    private String name;

    public Individual() {
    }

    public Individual(String name) {
        this.name = name;
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        if (name == null || name == "") {
            return super.toString();
        }
        return super.toString() + " name: " + name;
    }
}
