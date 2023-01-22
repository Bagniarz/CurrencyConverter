package currencyConverter;

import java.util.Arrays;

import static currencyConverter.menu.Menu.startMenu;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            startMenu(args[0]);
        } else {
            System.out.println("Only 1 argument allowed!");
        }
    }
}


