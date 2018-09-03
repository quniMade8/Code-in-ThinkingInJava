package parent.enumerated;

import static net.mindview.util.Print.*;
import static parent.enumerated.Signal.*;

enum Signal {GREEN, YELLOW, RED}


public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }
}
