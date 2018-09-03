package parent.demo.typeinfo.pets;

import java.util.ArrayList;

public class Pet extends Individual {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }

    public Pet() {
    }

    public Pet(String name) {
        super(name);
    }
}
