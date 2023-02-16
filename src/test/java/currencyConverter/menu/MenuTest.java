package currencyConverter.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void reverseCurrency() {
        assertAll(
                () -> assertTrue(Menu.reverseCurrency(false)),
                () -> assertFalse(Menu.reverseCurrency(true))
        );
    }
}