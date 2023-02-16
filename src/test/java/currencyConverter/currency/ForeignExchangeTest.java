package currencyConverter.currency;

import currencyConverter.exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForeignExchangeTest {

    @Test
    void truncate() {
        assertAll(
                () -> assertEquals(5.20, ForeignExchange.truncate(5.203895835, 2)),
                () -> assertEquals(74.867, ForeignExchange.truncate(74.8678, 3))
        );
    }

    @Test
    void convertCurrency() throws NegativeNumberException {
        ForeignExchange currency = new ForeignExchange("TEST", 5);
        assertAll(
                () -> assertEquals(400, ForeignExchange.convertCurrency(80, currency)),
                () -> assertEquals(37500, ForeignExchange.convertCurrency(7500, currency)),
                () -> assertThrows(NegativeNumberException.class, () -> ForeignExchange.convertCurrency(-50, currency))
        );
    }

    @Test
    void convertCurrencyReverse() throws NegativeNumberException {
        ForeignExchange currency = new ForeignExchange("TEST", 5);
        assertAll(
                () -> assertEquals(16000, ForeignExchange.convertCurrencyReverse(80000, currency)),
                () -> assertEquals(15, ForeignExchange.convertCurrencyReverse(75, currency)),
                () -> assertThrows(NegativeNumberException.class, () -> ForeignExchange.convertCurrency(-50, currency))
        );
    }
}