package parent.demo;

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    }
}

class StromException extends Exception {
}

class RainedOut extends StromException {
}

class PopFoul extends Foul {
}

interface Storm {
    void event() throws RainedOut;

    void rainedHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

    //构造函数必须处理基类构造函数的异常，此外，可添加额外的异常。
    public StormyInning() throws BaseballException, RainedOut {
    }

    public StormyInning(String s) throws BaseballException, RainedOut {

    }

    //编译错误，子类不能抛出父类未抛出的异常
    //void walk() throws Foul{}


    @Override
    public void atBat() throws Strike, Foul {

    }

    //接口不能向父类中已存在的方法添加异常
//    @Override
//    public void event() throws RainedOut{
//    }

    @Override
    public void event() {
    }

    @Override
    public void rainedHard() throws RainedOut {

    }

}
