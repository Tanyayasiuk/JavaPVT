package javapvt.FinalProject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.Arrays;


public class Dom {

    public static Root domParser(String path) {
        Document dom = null;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Root rootXML = new Root();

        Element root = dom.getDocumentElement();

        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);

        String name = nameNode.getFirstChild().getNodeValue();
        rootXML.setName(nameNode.getFirstChild().getNodeValue());
        //System.out.println("name = " + name);

        NodeList dateNodeList = root.getElementsByTagName("date");
        Node dateNode = dateNodeList.item(0);

        String date = dateNode.getFirstChild().getNodeValue();
        //System.out.println("date: " + date);
        rootXML.setDate(dateNode.getFirstChild().getNodeValue());

        NodeList busesNodeList = root.getElementsByTagName("schedule");
        Node busesNode = busesNodeList.item(0);
        //System.out.println("tag 4 = " + busesNode.getNodeName());

        NodeList elementsNodeList = busesNode.getChildNodes();


        ArrayList<Bus> schedule = new ArrayList<>();
        rootXML.setSchedule(schedule);

        for (int i = 0; i < elementsNodeList.getLength(); i++) {

            Node node = elementsNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Bus bus = new Bus();

            //System.out.println("======================================");

            Element element = (Element) node;

            // busNum
            NodeList nameElemlist = element.getElementsByTagName("busNumber");
            Element nameElement = (Element) nameElemlist.item(0);
            String busNum = nameElement.getFirstChild().getNodeValue();
            //System.out.println("busNumber : " + busNum);

            bus.setBusNumber(Integer.valueOf(busNum));

            // dateEnd
            String dateEnd = element.getElementsByTagName("dateEnd").item(0).getTextContent();
            //System.out.println("dateEnd : " + dateEnd);
            bus.setDateEnd(dateEnd);

            //dateStart
            String dateStart = element.getElementsByTagName("dateEnd").item(0).getTextContent();
            //System.out.println("dateStart : " + dateStart);
            bus.setDateStart(dateStart);

            // id
            String idBus = element.getElementsByTagName("id").item(0).getTextContent();
            //System.out.println("id : " + idBus);
            bus.setId(Integer.valueOf(idBus));

            // location
            String locationEnd = element.getElementsByTagName("locationEnd").item(0).getTextContent();
            //System.out.println("locationEnd : " + locationEnd);
            bus.setLocationEnd(locationEnd);

            //locationStart
            String locationStart = element.getElementsByTagName("locationStart").item(0).getTextContent();
            //System.out.println("locationStart : " + locationStart);
            bus.setLocationStart(locationStart);

            //price
            String price = element.getElementsByTagName("price").item(0).getTextContent();
            //System.out.println("price : " + price);
            bus.setPrice(Integer.valueOf(price));

            //waypoints - seem to work now
            NodeList e = element.getElementsByTagName("waypoints").item(0).getChildNodes();
            ArrayList<String> waypoints = new ArrayList<>();

            for (int j = 0; j < e.getLength(); j++){

                Node nodeE = e.item(j);

                if (nodeE.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (nodeE.getTextContent() != null)
                    waypoints.add(nodeE.getTextContent());

            }

            //System.out.println(waypoints.toString());
            bus.setWaypoints(waypoints);

            schedule.add(bus);
        }

        return rootXML;
    }


}
