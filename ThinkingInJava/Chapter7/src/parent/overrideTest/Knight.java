package parent.overrideTest;

class Warrior {
    public void move() {

    }

    public void move(int direction) {

    }

    public void move(int direction, int step) {

    }
}

class Cratos extends Warrior {
//    @Override
//    public void move(String to) {
//
//    }
}

public class Knight extends Warrior {
    public static void main(String[] args) {
        Cratos x = new Cratos();

    }
}
