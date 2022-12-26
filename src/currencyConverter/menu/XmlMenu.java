package currencyConverter.menu;

import currencyConverter.fileReader.XmlReader;

import java.util.ArrayList;

public class XmlMenu {

    public static ArrayList importCurrencyValuesXML() {
        ArrayList currencies = XmlReader.ReadXML();
        return currencies;
    }
}
