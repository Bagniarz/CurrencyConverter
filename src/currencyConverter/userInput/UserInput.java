package currencyConverter.userInput;

import java.util.Scanner;

public class UserInput {

    public static String stringUserInput() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result.toLowerCase();
    }
}
