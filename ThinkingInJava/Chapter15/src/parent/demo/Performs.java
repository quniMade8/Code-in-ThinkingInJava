package parent.demo;

public interface Performs {
    void speak();

    void sit();

}

class PerformingDog implements Performs {

    @Override
    public void speak() {
        System.out.println("Woof!");
    }

    @Override
    public void sit() {
        System.out.println("Sitting");
    }
}

class Communicate {
    public static void main(String[] args) {
        Communicate.perform(new PerformingDog());
    }

    static <T extends Performs> void perform(T x) {
        x.sit();
        x.speak();
    }
}
