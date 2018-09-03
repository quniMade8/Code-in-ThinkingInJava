package parent.enumerated.menu;

public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI, VINDALOO;
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, FRUIT;
    }
}
