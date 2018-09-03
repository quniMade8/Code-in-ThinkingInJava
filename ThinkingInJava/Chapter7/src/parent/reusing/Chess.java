package parent.reusing;

class Game {
    String var;

    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    //String var = "overrode var";
    Chess() {
        //导出类的构造函数会自动调用父类的构造函数，如父类无默认构造函数需手动调用
        super(2);
        System.out.println("Chess constructor");
        //不重写的情况下super.var和this.var是同一个对象
        System.out.println("super.var " + super.var);
        System.out.println("this.var " + this.var);
    }

    public static void main(String[] args) {
        Chess c = new Chess();
    }
}
