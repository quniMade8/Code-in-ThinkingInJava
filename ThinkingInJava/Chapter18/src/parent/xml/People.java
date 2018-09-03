package parent.xml;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;
import nu.xom.ParsingException;

import java.io.IOException;
import java.util.ArrayList;

public class People extends ArrayList<Person> {
    public People(String fileName) throws ParsingException, IOException {
        Document doc = new Builder().build(fileName);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++)
            add(new Person(elements.get(i)));
    }

    public static void main(String[] args) throws ParsingException, IOException {
        People p = new People("People.xml");
        System.out.println(p);
    }
}
