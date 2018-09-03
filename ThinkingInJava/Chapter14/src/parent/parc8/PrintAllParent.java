package parent.parc8;

import java.util.ArrayList;
import java.util.Formatter;

class PrintClassAndItsParents {
    private static Formatter formatter = new Formatter(System.out);

    public static void print(Class clazz, int spaceCount) {
        if (clazz == null) {
            System.exit(1);
        }
        //打印当前类的信息
        formatter.format("%" + spaceCount + "." + spaceCount + "s Class name: " + clazz.getCanonicalName() + "\n", " ");
        //打印接口
        for (Class face : clazz.getInterfaces()) {
            formatter.format("%" + spaceCount + "." + spaceCount + "s Interface names: " + face + ",", " ");
        }
        System.out.println();
        //寻找父类
        if (clazz.getSuperclass() != null) {
            print(clazz.getSuperclass(), ++spaceCount);
        }

    }
}

public class PrintAllParent {
    public static void main(String[] args) {
        PrintClassAndItsParents.print(Integer.class, 1);
    }
}
