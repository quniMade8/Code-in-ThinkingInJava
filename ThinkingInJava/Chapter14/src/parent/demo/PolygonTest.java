package parent.demo;

interface Shape {
    String draw();
}

class Rhomboid implements Shape {
    @Override
    public String draw() {
        return "Rhomboid " + this;
    }
}

class Circle implements Shape {
    @Override
    public String draw() {
        return "Circle " + this;
    }
}

public class PolygonTest {
    public static void main(String[] args) {

    }
}
