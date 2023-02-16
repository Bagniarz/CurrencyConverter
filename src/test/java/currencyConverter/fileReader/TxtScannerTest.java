package currencyConverter.fileReader;

import currencyConverter.currency.ForeignExchange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TxtScannerTest {

    @Test
    void formatNumber() {
        assertAll(
                () -> assertEquals("5.23", TxtScanner.formatNumber("5,23")),
                () -> assertEquals("7.75", TxtScanner.formatNumber("7,75"))
        );
                //() -> assertThrows(ParseException.class, () -> TxtScanner.formatNumber("")));
    }

    @Test
    void isNumber() {
        assertAll(
                () -> assertTrue(TxtScanner.isNumber("2")),
                () -> assertTrue(TxtScanner.isNumber("52.2356")),
                () -> assertFalse(TxtScanner.isNumber("A"))
        );
    }

    @Test
    void createCurrency() {
        assertAll(
                () -> assertEquals(new ForeignExchange("TEST", 2.0), TxtScanner.createCurrency("TEST 2,0")),
                () -> assertEquals(new ForeignExchange("TEST" , 80), TxtScanner.createCurrency("TEST 80")),
                () -> assertEquals(new ForeignExchange("TEST", 2.23), TxtScanner.createCurrency("TEST 2,238754"))
        );
    }
}