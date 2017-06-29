package javapvt.FinalProject;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class ParseXML extends DefaultHandler {

    String thisElement = "";
    ArrayList<Bus> schedule = new ArrayList<>();
    Bus bus;
    static Root root = new Root();


    public static Root parseXML(String path) {
        ParseXML sax = new ParseXML();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(path, sax);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sax.root.setSchedule(sax.schedule);
        //System.out.println(sax.root);

        return root;
    }

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
        if (qName.equals("element")) {
            bus = new Bus();
        }
        thisElement = qName;
        //System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String name, String qName) {
        if (qName.equals("element")) {
            schedule.add(bus);
        }
        thisElement = "";
        //System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char ch[], int start, int length) {

        switch (thisElement) {
            case "busNumber":
                bus.setBusNumber(Integer.parseInt(new String(ch, start, length)));
                break;
            case "dateEnd":
                bus.setDateEnd(new String(ch, start, length));
                break;
            case "dateStart":
                bus.setDateStart(new String(ch, start, length));
                break;
            case "id":
                bus.setId(Integer.parseInt(new String(ch, start, length)));
                break;
            case "locationEnd":
                bus.setLocationEnd(new String(ch, start, length));
                break;
            case "locationStart":
                bus.setLocationStart(new String(ch, start, length));
                break;
            case "price":
                bus.setPrice(Integer.parseInt(new String(ch, start, length)));
                break;
            case "waypoints":
                //bus.setWaypoints(new String[](ch, start, length));
                break;
            case "name":
                root.setName( new String(ch, start, length));
                break;
            case "date":
                root.setDate(new String(ch, start, length));
                break;
        }

    }
}