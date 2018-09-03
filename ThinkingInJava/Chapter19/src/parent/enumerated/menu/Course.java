package parent.enumerated.menu;

import net.mindview.util.Enums;

public enum Course {
    APPTIZER(Food.Appetizer.class),

    MAINCOURSE(Food.MainCourse.class),

    DESSERT(Food.Dessert.class);

    private Food[] values;

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}
