package currencyConverter.currency;

import currencyConverter.exceptions.NegativeNumberException;

import java.util.Objects;

public class ForeignExchange {
    private final String abbreviation;
    private final double price;

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getPrice() {
        return price;
    }

    public ForeignExchange(String name, String abbreviation, double price) {
        this.abbreviation = abbreviation;
        this.price = price;
    }

    public ForeignExchange(String abbreviation, double price) {
        this("", abbreviation, price);
    }
    public static ForeignExchange readCurrency(String line) {
        String name = line.substring(0,3);
        float price = Float.parseFloat(line.substring(4,8));
        return new ForeignExchange(name, price);
    }

    public static double truncate(double number, int decimalPlace) {
        return (Math.floor(number * Math.pow(10, decimalPlace))) / Math.pow(10, decimalPlace);
    }

    public static double convertCurrency(double value, ForeignExchange currency) throws NegativeNumberException {
        if (value < 0) {
            throw new NegativeNumberException();
        } else {
            return value * currency.getPrice();
        }
    }

    public static double convertCurrencyReverse(double value, ForeignExchange currency) throws NegativeNumberException {
        if (value < 0) {
            throw new NegativeNumberException();
        } else {
            return value / currency.getPrice();
        }
    }

    @Override
    public String toString() {
        return abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForeignExchange that = (ForeignExchange) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, price);
    }
}
