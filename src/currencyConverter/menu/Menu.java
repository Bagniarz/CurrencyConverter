package currencyConverter.menu;

import currencyConverter.fileReader.Reader;
import currencyConverter.userInput.UserInput;

import java.util.ArrayList;


public class Menu {


    public static void printMenu() {
        System.out.println("Menu: " + "\nStart" + "\nQuit");
    }

    public static void importCurrencyValues() {
        ArrayList currencies = Reader.read();
    }

    public static void startMenu() {
        importCurrencyValues();
        printMenu();
        String input = UserInput.stringUserInput();
    }
}


