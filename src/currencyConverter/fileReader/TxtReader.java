package currencyConverter.fileReader;

import currencyConverter.currency.ForeignExchange;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TxtReader {

    public static String convert(String input) {
        input = input.replace("," , ".");
        return input;
    }

    public static ArrayList txtRead(File file) {
        Scanner scanner;
        String line = "";
        ArrayList<ForeignExchange> result = new ArrayList<>();
        ForeignExchange currency = null;
        int count = 0;
        try {
            scanner = new Scanner(new FileReader(file));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                line = convert(line);
                currency = ForeignExchange.txtCurrency(line);
                result.add(count, currency);
                count++;
            }
            scanner.close();
        } catch (IOException ioException) {
            System.err.println("Error with loading file");
            ioException.printStackTrace();
        }
        return result;
    }

    public static ArrayList txtImportArr() {
        ArrayList<ForeignExchange> result = txtRead(new File("E:/Java Projects/CurrencyConverter/src/resources/Currency.txt"));
        return result;
    }
}
