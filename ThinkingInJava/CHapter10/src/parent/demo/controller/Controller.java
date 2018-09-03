package parent.demo.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event x : new ArrayList<Event>(eventList)) {
                if (x.ready()) {
                    System.out.println(x);
                    x.action();
                    eventList.remove(x);
                }
            }
        }
    }
}
