package currencyConverter.menu;

import currencyConverter.fileReader.TxtReader;
import java.util.ArrayList;

public class TxtMenu {

    public static ArrayList importCurrencyValuesTxt() {
        ArrayList currencies = TxtReader.txtImportArr();
        return currencies;
    }
}
