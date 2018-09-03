package parent.prac25.outerpack;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invoker {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("parent.prac25.thepack.TheToolClass");
            Field f = c.getDeclaredField("name");
            f.setAccessible(true);
            System.out.println(f.get(c.newInstance()));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
