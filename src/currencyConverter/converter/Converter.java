package currencyConverter.converter;

public class Converter {

    // For now it's double. Later I will change it to BigDecimal
    public static double convertCurrency(double value, double price) {
        return value*price;
    }

    public static double convertCurrencyReverse(double value, double price) {
        return value/price;
    }
}
