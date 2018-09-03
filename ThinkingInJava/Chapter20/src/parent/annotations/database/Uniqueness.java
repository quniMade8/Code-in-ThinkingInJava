package parent.annotations.database;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
