package parent.prac30;

public class Pet {
    private static long counter;
    private long id = counter++;

    @Override
    public String toString() {
        return "Pet " + id;
    }
}
