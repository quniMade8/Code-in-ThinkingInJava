package parent.demo;

class Employee {
}

class ClassAsFacotry<T> {
    T x;

    public ClassAsFacotry(Class<T> type) {
        try {
            x = type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

public class InstantiationGenericType {
    public static void main(String[] args) {
        ClassAsFacotry<Employee> classAsFacotry = new ClassAsFacotry<>(Employee.class);
    }
}
