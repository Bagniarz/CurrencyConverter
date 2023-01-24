package currencyConverter.userInput;

import java.util.Scanner;

public class UserInput {

    public static String askUserString() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result.toLowerCase();
    }
    public static double askUserDouble() {
        Scanner scanner = new Scanner(System.in);
        double input = 0;
        boolean error = false;
        try {
            input = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("This is not a number!");
            e.printStackTrace();
            error = true;
        }
        if (!error && input > 0) {
            return input;
        } else {
            return -1;
        }
    }
    public static int askUserInt() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean error = false;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("This is not a number!");
            e.printStackTrace();
            error = true;
        }
        if (!error && input > 0) {
            return input;
        } else {
            return -1;
        }
    }
}
