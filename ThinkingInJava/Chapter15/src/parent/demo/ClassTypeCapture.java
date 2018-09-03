package parent.demo;

import java.util.HashMap;
import java.util.Map;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> typeMap = new HashMap<>();
    Map<String, Class<?>> test = new HashMap<>();

    void test() {
        test.put("a", String.class);
        test.put("b", Integer.class);
    }

    void addType(String typeName, Class<?> kind) {
        typeMap.put(typeName, kind);
    }

    Object creatNew(String typeName) {
        if (typeMap.get(typeName) != null) {
            try {
                return typeMap.get(typeName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
//        ClassTypeCapture<Building> classTypeCapture = new ClassTypeCapture<Building>(Building.class);
//        System.out.println(classTypeCapture.f(new House()));
        ClassTypeCapture classTypeCapture = new ClassTypeCapture(Building.class);
        classTypeCapture.test();
    }
}
