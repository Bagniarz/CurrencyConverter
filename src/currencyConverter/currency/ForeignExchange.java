package currencyConverter.currency;

public class ForeignExchange {
    String name;
    String abbreviation;
    double price;

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getPrice() {
        return price;
    }

    public ForeignExchange(String name, String abbreviation, double price) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.price = price;
    }

    public ForeignExchange(String abbreviation, double price) {
        this.abbreviation = abbreviation;
        this.price = price;
    }

    public static ForeignExchange txtCurrency(String line) {
        String name = line.substring(0,3);
        float price = Float.parseFloat(line.substring(4,8));
        return new ForeignExchange(name, price);
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
