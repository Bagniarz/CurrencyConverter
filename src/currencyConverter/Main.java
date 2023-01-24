package currencyConverter;

import currencyConverter.exceptions.NegativeNumberException;

import static currencyConverter.menu.Menu.startMenu;

public class Main {
    public static void main(String[] args) throws NegativeNumberException {
        if (args.length < 2) {
            startMenu(args[0]);
        } else {
            System.out.println("Only 1 argument allowed!");
        }
    }
}


