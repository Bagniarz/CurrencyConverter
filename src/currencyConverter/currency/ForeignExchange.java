package currencyConverter.currency;

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
    //TODO split, truncate(need to implement myself)
    public static ForeignExchange readCurrency(String line) {
        String name = line.substring(0,3);
        float price = Float.parseFloat(line.substring(4,8));
        return new ForeignExchange(name, price);
    }

    public static double convertCurrency(double value, double price) {
        return value*price;
    }

    public static double convertCurrencyReverse(double value, double price) {
        return value/price;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
