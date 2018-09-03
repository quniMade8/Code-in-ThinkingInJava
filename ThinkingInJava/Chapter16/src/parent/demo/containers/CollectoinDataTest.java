package parent.demo.containers;

import parent.util.CollectionData;
import parent.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Government implements Generator<String> {
    String[] fundation = ("strange women lying in ponds distributing swords is no basis for a system of government").split(" ");
    private int index;

    @Override
    public String next() {
        return fundation[index++];
    }
}

public class CollectoinDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(CollectionData.list(new Government(), 5));
        System.out.println(set);
    }
}
