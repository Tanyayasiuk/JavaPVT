package javapvt.lesson12;

import java.util.ArrayList;
import org.xml.sax.Attributes;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * Created by ОК on 18.06.2017.
 */
public class Sax extends DefaultHandler{

    String thisElement = "";
    ArrayList<People> list = new ArrayList<>();
    People people;
    Root root = new Root();
    boolean fname = false;

    public static void main (String[] args) throws Exception {

        Sax sax = new Sax();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse("test.xml", sax);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sax.root.setPeople(sax.list);
        System.out.println(sax.root);

    }

    @Override
    public void startDocument() {
        System.out.println("Start parsing...");
    }

    @Override
    public void endDocument() {
        System.out.println("...End of document.\n");
    }

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
        if (qName.equals("element")) {
            people = new People();
        }
        thisElement = qName;
        //System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String name, String qName) {
        if (qName.equals("element")) {
            list.add(people);
        }
        thisElement = "";
        //System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char ch[], int start, int length) {

        switch (thisElement) {
            case "age":
                people.setAge(Integer.parseInt(new String(ch, start, length)));
                break;
            case "id":
                people.setId(Integer.parseInt(new String(ch, start, length)));
                break;
            case "isDegree":
                people.setDegree(Boolean.parseBoolean(new String(ch, start, length)));
                break;
            case "name":
                if (fname) {
                    people.setName(new String(ch, start, length));
                } else {
                    root.setName(new String(ch, start, length));
                    fname = true;
                }
                break;
            case "surname":
                people.setSurname(new String(ch, start, length));
                break;
        }

    }

}




