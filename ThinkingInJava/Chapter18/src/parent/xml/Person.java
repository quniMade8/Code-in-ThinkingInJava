package parent.xml;

import nu.xom.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String first, last, address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        Element addr = new Element("address");
        addr.appendChild(address);
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(addr);
        return person;
    }

    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }

    @Override
    public String toString() {
        return first + " " + last + " address: " + address;
    }

    //Make it human-readable:
    public static void format(OutputStream os, Document doc) throws IOException {
        Serializer serializer = new Serializer(os, "UTF-8");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws IOException {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew", "LA"),
                new Person("Gonzo", "The Great", "NYC"),
                new Person("Phillip J.", "Fry", "SNH"));
        System.out.println(people);
        Element root = new Element("people");
        for (Person p : people)
            root.appendChild(p.getXML());
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(
                new FileOutputStream("People.xml")), doc);
    }
}
