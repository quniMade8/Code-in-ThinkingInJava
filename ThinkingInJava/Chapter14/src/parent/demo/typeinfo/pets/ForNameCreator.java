package parent.demo.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "parent.demo.typeinfo.pets.Mutt",
            "parent.demo.typeinfo.pets.Pug",
            "parent.demo.typeinfo.pets.EgyptianMau",
            "parent.demo.typeinfo.pets.Manx",
            "parent.demo.typeinfo.pets.Cymric",
            "parent.demo.typeinfo.pets.Rat",
            "parent.demo.typeinfo.pets.Mouse",
            "parent.demo.typeinfo.pets.Hamster",
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
