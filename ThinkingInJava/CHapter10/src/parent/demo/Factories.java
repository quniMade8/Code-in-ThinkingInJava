package parent.demo;

interface Service {
    void method1();

    void method2();
}

interface ServiceFacotry {
    Service getService();
}

class Implementation1 implements Service {

    @Override
    public void method1() {
        System.out.println("Implementation1.method1()");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1.method2()");
    }

    public static ServiceFacotry facotry = new ServiceFacotry() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {

    @Override
    public void method1() {
        System.out.println("Implementation2.method1()");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2.method2()");
    }

    public static ServiceFacotry facotry = new ServiceFacotry() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}

public class Factories {
    public static void serviceConsumer(ServiceFacotry facotry) {
        Service x = facotry.getService();
        x.method1();
        x.method2();
    }

    public static void main(String[] args) {
        Factories.serviceConsumer(Implementation1.facotry);
        Factories.serviceConsumer(Implementation2.facotry);
    }
}
