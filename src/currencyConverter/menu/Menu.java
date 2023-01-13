package currencyConverter.menu;

import currencyConverter.currency.ForeignExchange;
import currencyConverter.userInput.UserInput;
import java.util.List;

import static currencyConverter.currency.ForeignExchange.convertCurrency;
import static currencyConverter.currency.ForeignExchange.convertCurrencyReverse;
import static currencyConverter.fileReader.TxtScanner.importTxtValues;
import static currencyConverter.fileReader.XmlScanner.importXmlValues;

public class Menu {

    public static void printMenu() {
        System.out.println("""
                Menu:\s
                Start
                Currency
                Xml
                Quit""");
    }

    public static void displayResult(double result, String abbreviation, boolean reverse) {
        if (!reverse) {
            System.out.println("Value:" + result + " PLN");
        } else {
            System.out.println("Value:" + result + " " + abbreviation);
        }
    }

    public static void showCurrencies(List<ForeignExchange> list) {
        int count = 0;
        for (Object currency : list) {
            System.out.println(count + ":" + currency);
            count++;
        }
    }

    public static void printConvertMenu() {
        System.out.println("""
                Start
                Reverse
                Back""");
    }

    public static boolean reverseCurrency(boolean reverse) {
        return !reverse;
    }

    public static double convert(double price, boolean reverse) {
        System.out.println("Enter value which you want to convert");
        double input = UserInput.askUserDouble();
        double result;
        if (reverse) {
            result = convertCurrencyReverse(input, price);
        } else {
            result = convertCurrency(input, price);
        }
        return result;
    }

    public static void initConvert(List<ForeignExchange> list, int input) {
        ForeignExchange currency =  list.get(input);
        boolean reverse = false;
        boolean endConvert = false;
        double result;
        while (!endConvert) {
            if (reverse) {
                System.out.println("You are converting PLN to " + list.get(input));
            } else {
                System.out.println("You are converting " + list.get(input) + " to PLN");
            }
            System.out.println("Price: " + currency.getPrice());
            printConvertMenu();
            String userString = UserInput.askUserString();
            switch (userString) {
                case "s", "start" -> {
                    result = convert(currency.getPrice(), reverse);
                    displayResult(result, currency.getAbbreviation(), reverse);
                }
                case "r", "reverse" -> {
                    reverse = reverseCurrency(reverse);
                }
                default -> {
                    endConvert = true;
                }
            }
        }
    }

    public static void startApp(List<ForeignExchange> list) {
        boolean returnToMenu = false;
        while (!returnToMenu) {
            showCurrencies(list);
            System.out.println("Choose which currency you want to convert " +
                    "(Use numbers before listed currencies or write -1 to go back)");
            int input = UserInput.askUserInt();
            if (input > -1 && input < list.size()) {
                initConvert(list, input);
                returnToMenu = true;
            } else if(input > list.size()) {
                System.out.println("You entered wrong number! Choosing first currency...");
                initConvert(list, 0);
                returnToMenu = true;
            } else {
                returnToMenu = true;
            }
        }
    }

    public static void startMenu() {
        boolean closeProgram = false;
        boolean xml = false;
        while (!closeProgram) {
            printMenu();
            String input = UserInput.askUserString();
            switch (input) {
                case "s", "start" -> {
                    if (xml) {
                        startApp(importXmlValues());
                    } else {
                        startApp(importTxtValues());
                    }
                }
                case "c", "currency" -> {
                    if (xml) {
                        showCurrencies(importXmlValues());
                    } else {
                        showCurrencies(importTxtValues());
                    }
                }
                case "x", "xml" -> {
                    xml = true;
                }
                default -> {
                    closeProgram = true;
                }
            }
        }
    }
}


