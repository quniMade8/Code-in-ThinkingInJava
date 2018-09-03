package parent.demo;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public void set(T val) {
        this.value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<>(new Apple());
        Apple d = Apple.get();
        //cannot upcast
        //Holder<Furit> Fruit = Apple;
        Holder<? extends Furit> fruit = Apple;
        Furit p = fruit.get();
        d = (Apple) fruit.get();//Returns Object
        try {
            Orange o = (Orange) fruit.get();//No warning
        } catch (Exception e) {
            System.out.println(e);
        }
        //在使用通配符的情况下,参数列表中有类型参数的方法将无法被调用
        //wouldn't compile
//        fruit.set(new Apple());
//        fruit.set(new Furit());
        //参数列表中无类型参数的方法可以正常被调用
        System.out.println(fruit.equals(d));//ok

    }
}
