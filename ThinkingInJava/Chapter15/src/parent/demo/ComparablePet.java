package parent.demo;

class Pet {
}

//class Cat extends ComparablePet implements Comparable<Cat> {
//}


public class ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
