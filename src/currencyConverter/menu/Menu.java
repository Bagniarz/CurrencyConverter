package currencyConverter.menu;

import currencyConverter.converter.Converter;
import currencyConverter.currency.ForeignExchange;
import currencyConverter.userInput.UserInput;
import java.util.ArrayList;

import static currencyConverter.menu.TxtMenu.importCurrencyValuesTxt;
import static currencyConverter.menu.XmlMenu.importCurrencyValuesXML;

public class Menu {

    //TODO sort methods and classes in menu package

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

    public static void showCurrencies(ArrayList list) {
        int count = 0;
        for (Object currency : list) {
            System.out.println(count + ":" + currency);
            count++;
        }
    }

    public static void printConvertMenu() {
        System.out.println("Start" + "\nReverse" + "\nBack");
    }

    public static boolean reverse(boolean reverse) {
        if (reverse) {
            reverse = false;
        } else {
            reverse = true;
        }
        return reverse;
    }

    public static double convert(double price, boolean reverse) {
        System.out.println("Enter value which you want to convert");
        double input = UserInput.askUserDouble();
        double result = 0;
        if (reverse) {
            result = Converter.convertCurrencyReverse(input, price);
        } else {
            result = Converter.convertCurrency(input, price);
        }
        return result;
    }

    public static void startConverter(ArrayList list) {
        boolean returnToMenu = false;
        while (!returnToMenu) {
            showCurrencies(list);
            System.out.println("Choose which currency you want to convert " +
                    "(Use numbers before listed currencies or write -1 to go back)");
            int input = UserInput.askUserInt();
            if (input > 0 && input < list.size()) {
                initConvert(list, input);
            } else if(input > list.size()) {
                System.out.println("You entered wrong number! Choosing first currency...");
                initConvert(list, 0);
            } else {
                returnToMenu = true;
            }
        }
    }

    public static void initConvert(ArrayList list, int input) {
        ForeignExchange currency = (ForeignExchange) list.get(input);
        boolean reverse = false;
        boolean endConvert = false;
        double result = 0;
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
                case "r", "reverse" -> reverse = reverse(reverse);
                default -> endConvert = true;
            }
        }
    }

    //TODO implement enhanced switch
    public static void startApp() {
        boolean closeProgram = false;
        boolean xml = false;
        while (!closeProgram) {
            printMenu();
            String input = UserInput.askUserString();
            switch (input) {
                case "s":
                case "start":
                    if (xml) {
                        startConverter(importCurrencyValuesXML());
                    } else {
                        startConverter(importCurrencyValuesTxt());
                    }
                    break;
                case "c":
                case "currency":
                    if (xml) {
                        showCurrencies(importCurrencyValuesXML());
                    } else {
                        showCurrencies(importCurrencyValuesTxt());
                    }
                    break;
                case "x":
                case "xml":
                    xml = true;
                    break;
                default:
                    closeProgram = true;
            }
        }
    }
}


