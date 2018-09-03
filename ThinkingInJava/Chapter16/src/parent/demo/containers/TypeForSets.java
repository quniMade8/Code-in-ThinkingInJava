package parent.demo.containers;

class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && ((SetType) obj).i == i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        return (o.i < i ? -1 : (o.i == i ? 0 : -1));
    }
}

public class TypeForSets {

}
