package parent.prac16;

interface Cycle {
    void run();
}

interface CycleFacotry {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public static CycleFacotry facotry = new CycleFacotry() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };

    @Override
    public void run() {
        System.out.println("Unicycle.run");
    }
}

class Bicycle implements Cycle {
    public static CycleFacotry facotry = new CycleFacotry() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };

    @Override
    public void run() {
        System.out.println("Bicycle.run");
    }
}

public class CycleFactories {
    private static void factoryConsumer(CycleFacotry facotry) {
        Cycle x = facotry.getCycle();
        x.run();
    }

    public static void main(String[] args) {
        CycleFactories.factoryConsumer(Bicycle.facotry);
        CycleFactories.factoryConsumer(Unicycle.facotry);
    }
}
