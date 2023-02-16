package currencyConverter.userInput;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void askUserString() {
        InputStream stream = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Abc".getBytes());
        System.setIn(in);
        assertEquals("abc", UserInput.askUserString());
    }

    @Test
    void askUserDouble() {
        InputStream stream = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("50.2".getBytes());
        System.setIn(in);
        assertEquals(50.2, UserInput.askUserDouble());
    }

    @Test
    void askUserInt() {
        InputStream stream = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        assertEquals(2, UserInput.askUserInt());
    }
}