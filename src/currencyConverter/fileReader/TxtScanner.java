package currencyConverter.fileReader;

import currencyConverter.currency.ForeignExchange;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TxtScanner {

    public static String formatNumber(String line) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number;
        try {
            number = format.parse(line);
            return String.valueOf(number);
        } catch (ParseException e) {
            return "";
        }
    }

    public static boolean isNumber(String element) {
        try {
            Double.parseDouble(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static ForeignExchange createCurrency(String line) {
        String[] arr = line.split("\\s"); // Do Zobaczenia
        String name = null;
        double price = 0;
        for (String element : arr) {
            boolean numeric = isNumber(formatNumber(element));
            if (numeric) {
                price = Double.parseDouble(formatNumber(element));
            } else {
                name = element;
            }
        }
        return new ForeignExchange(name, price);
    }

    public static List<ForeignExchange> readTxt(File file) {
        Scanner scanner;
        String line = "";
        ArrayList<ForeignExchange> result = new ArrayList<>();
        ForeignExchange currency;
        try {
            scanner = new Scanner(new FileReader(file));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                currency = createCurrency(line);
                result.add(currency);
            }
            scanner.close();
        } catch (IOException ioException) {
            System.err.println("Error with loading file");
            ioException.printStackTrace();
        }
        return result;
    }

    //TODO Ask user about pathname;
    public static List<ForeignExchange> importTxt(String path) {
        return readTxt(new File(path));
    }

    public static List<ForeignExchange> importTxtValues(String path) {
        return TxtScanner.importTxt(path);
    }
}
