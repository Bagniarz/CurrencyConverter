package currencyConverter.currency;

public class ForeignExchange {
    String name;
    float price;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ForeignExchange(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public static ForeignExchange currency(String line) {
        String name = line.substring(0,3);
        float price = Float.parseFloat(line.substring(4,8));
        return new ForeignExchange(name, price);
    }

    @Override
    public String toString() {
        return "[" + name + "]" + " " + price;
    }
}
