package parent.demo.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class DynamicProxyHandler implements InvocationHandler {
    private static Map<String, Long> counter = new HashMap<>();
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Long quantity = counter.get(method.getName());
        counter.put(method.getName(), quantity == null ? 1 : quantity + 1);
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }

        //调用proxy的接口会重定向到invoke()，在invoke()里面继续调用proxy的接口，引起死循环。
        //System.out.println("proxy: " + proxy);
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomething();
        iface.somethingElse("ladida");
        iface.somethingElse("ladida");
    }

    public static void main(String[] args) {
        RealObjec real = new RealObjec();
        //consumer(real);

        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
