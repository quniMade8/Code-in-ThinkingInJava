package parent.demo.typeinfo;

import java.util.HashMap;
import java.util.Map;

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObjec implements Interface {
    @Override
    public void doSomething() {
        System.out.println("Do something");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("Something else " + arg);
    }
}

class SimpleProxy implements Interface {
    private static Map<String, Long> counter = new HashMap<>();
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        Long quantity = counter.get("doSomething()");
        counter.put("doSomething()", quantity == null ? 1 : quantity + 1);
        System.out.println("Simple proxy do something");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        Long quantity = counter.get("somethingElse()");
        counter.put("somethingElse()", quantity == null ? 1 : quantity + 1);
        System.out.println("Simple proxy do something else");
        proxied.somethingElse(arg);
    }
}


public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomething();
        iface.doSomething();
        iface.doSomething();
        iface.somethingElse("ladida");
        iface.somethingElse("ladida");
    }

    public static void main(String[] args) {
        consumer(new RealObjec());
        consumer(new SimpleProxy(new RealObjec()));
    }
}
