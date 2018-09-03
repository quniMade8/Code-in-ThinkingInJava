package parent.demo;

abstract class GenericWithCreate<T> {
    final T x;

    public abstract T create();

    public GenericWithCreate() {
        x = create();
    }
}

class X {

}

class Creator extends GenericWithCreate<X> {
    @Override
    public X create() {
        return new X();
    }
}

public class CreatorGeneric {
}
