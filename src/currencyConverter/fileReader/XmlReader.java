package currencyConverter.fileReader;

import currencyConverter.currency.ForeignExchange;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XmlReader {
    public static ArrayList importData(NodeList list) {

        ArrayList<ForeignExchange> currencies = new ArrayList<>();
        ForeignExchange currency;
        for (int i = 0; i < list.getLength(); i++) {

            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String name = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                String abbreviation = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                double price = Double.parseDouble(element
                        .getElementsByTagName("kurs_sredni")
                        .item(0).getTextContent()
                        .replace(",", "."));

                currency = new ForeignExchange(name, abbreviation, price);
                currencies.add(i, currency);
            }
        }
        return currencies;
    }

    public static NodeList importNodeList() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        NodeList list = null;
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("src/resources/KursyWalut.xml"));
            doc.getDocumentElement().normalize();
            list = doc.getElementsByTagName("pozycja");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList ReadXML() {
        ArrayList<ForeignExchange> currencies = importData(importNodeList());
        return currencies;
    }
}

