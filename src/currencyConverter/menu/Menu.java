package currencyConverter.menu;

import currencyConverter.converter.Converter;
import currencyConverter.currency.ForeignExchange;
import currencyConverter.fileReader.Reader;
import currencyConverter.userInput.UserInput;
import java.util.ArrayList;

public class Menu {


    public static void printMenu() {
        System.out.println("Menu: " + "\nStart" + "\nCurrency" + "\nQuit");
    }

    public static ArrayList importCurrencyValues() {
        ArrayList currencies = Reader.importArr();
        return currencies;
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

    public static void displayResult(double result, String name, boolean reverse) {
        if (!reverse) {
            System.out.println("Value:" + result + " pln");
        } else {
            System.out.println("Value:" + result + " " + name);
        }
    }

    public static boolean reverse(boolean reverse) {
        if (reverse) {
            reverse = false;
        } else {
            reverse = true;
        }
        return reverse;
    }

    public static double convert(float price, boolean reverse) {
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

    public static void initConvert(ArrayList list, int input) {
        ForeignExchange currency = (ForeignExchange) list.get(input);
        boolean reverse = false;
        boolean endConvert = false;
        double result = 0;
        while (!endConvert) {
            if (reverse) {
                System.out.println("You are converting pln to " + list.get(input));
            } else {
                System.out.println("You are converting " + list.get(input) + " to pln");
            }
            printConvertMenu();
            String userString = UserInput.askUserString();
            switch (userString) {
                case "s":
                case "start":
                    result = convert(currency.getPrice(), reverse);
                    displayResult(result, currency.getName(), reverse);
                    break;
                case "r":
                case "reverse":
                    reverse = reverse(reverse);
                    break;
                default:
                    endConvert = true;
            }
        }
    }

    public static void startConverter(ArrayList list) {
        boolean returnToMenu = false;
        while (!returnToMenu) {
            showCurrencies(list);
            System.out.println("Choose which currency you want to convert (Use numbers before listed currencies)");
            int input = UserInput.askUserInt();
            if (input > 0 && input < list.size()) {
                initConvert(list, input);
            } else {
                System.out.println("You entered wrong number! Choosing first currency...");
                initConvert(list, 0);
            }
        }
    }

    public static void startApp() {
        boolean closeProgram = false;
        while (!closeProgram) {
            printMenu();
            String input = UserInput.askUserString();
            switch (input) {
                case "s":
                case "start":
                    startConverter(importCurrencyValues());
                    break;
                case "c":
                case "currency":
                    showCurrencies(importCurrencyValues());
                    break;
                default:
                    closeProgram = true;
            }
        }
    }
}


