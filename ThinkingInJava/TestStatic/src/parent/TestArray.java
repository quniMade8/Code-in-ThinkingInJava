package parent;

class TheClass {
    TheClass(String str) {
        System.out.println(str);
    }
}

public class TestArray {
    public static void main(String[] args) {
        TheClass[] array = new TheClass[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = new TheClass(String.valueOf(i));
        }

        TheClass[] array2 = new TheClass[]{
                new TheClass("hehe"),
                new TheClass("haha")
        };
        System.out.println(array2.length);
    }
}
