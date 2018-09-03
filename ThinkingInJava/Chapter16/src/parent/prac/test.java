package parent.prac;

import parent.typeinfo.pets.Individual;

import java.util.*;

class Person implements Comparable<Person> {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && id == ((Person) obj).id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * id;
        result = 37 * name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}


public class test {
    public static void main(String[] args) {
        //equals相同,hashcode不相同
        //可以添加到HashSet
        //在Set中，hashCode散列到相同的桶位，并且equals()==true才能算作相同的对象
        Person p1 = new Person(1, "name1");
        Person p2 = new Person(1, "name2");
        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        //可以添加到TreeSet
        set = new TreeSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        //可以添加到HashMap
        Map<Person, Integer> map = new HashMap<>();
        map.put(p1, 1);
        map.put(p2, 1);
        System.out.println(map);
    }
}
