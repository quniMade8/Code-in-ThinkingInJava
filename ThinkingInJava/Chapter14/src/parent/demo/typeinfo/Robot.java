package parent.demo.typeinfo;

import java.util.List;

public interface Robot {
    String name();

    String model();

    List<Operation> operations();

    class Test {
        public static void test(Robot r) {
            if (r instanceof Null) {
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for (Operation x : r.operations()) {
                System.out.println(x.description());
                x.command();
            }
        }
    }
}
