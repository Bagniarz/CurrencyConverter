package currencyConverter.exceptions;

public class NegativeNumberException extends Exception {

    private double value;

    public NegativeNumberException() {
        super();
    }

    @Override
    public String toString() {
        return "NegativeNumberException. You can't convert negative numbers!";
    }
}
