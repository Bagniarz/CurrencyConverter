package currencyConverter.userInput;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileChooserTest {

    @Test
    void isPath() {
        FileChooser fileChooser = new FileChooser("");
        assertAll(
                () -> assertTrue(fileChooser.isPath("E:\\Diablo II Resurrected\\Data\\data")),
                () -> assertFalse(fileChooser.isPath(null))
        );
    }

    @Test
    void isArg() {
        FileChooser fileChooser = new FileChooser("");
        assertAll(
                () -> assertTrue(fileChooser.isArg("asd")),
                () -> assertFalse(fileChooser.isArg(null)),
                () -> assertFalse(fileChooser.isArg("           "))
        );
    }

    @Test
    void isValidExtension() {
        FileChooser fileChooser = new FileChooser("");
        assertAll(
                () -> assertTrue(fileChooser.isValidExtension("abc.txt")),
                () -> assertTrue(fileChooser.isValidExtension("abc.xml")),
                () -> assertFalse(fileChooser.isValidExtension("abc.bat")),
                () -> assertFalse(fileChooser.isValidExtension("abc"))
        );
    }

    @Test
    void isValidPath() {
        FileChooser fileChooser = new FileChooser("abc");
        FileChooser fileChooser1 = new FileChooser("E:\\Diablo II Resurrected\\Data\\data");
        FileChooser fileChooser2 = new FileChooser("E:\\Java Projects\\CurrencyConverter\\src\\main\\java\\resources\\KursyWalut.xml");
        assertAll(
                () -> assertFalse(fileChooser.isValidPath(fileChooser)),
                () -> assertFalse(fileChooser1.isValidPath(fileChooser1)),
                () -> assertTrue(fileChooser2.isValidPath(fileChooser2))
        );
    }

    @Test
    void getExtension() {
        FileChooser fileChooser = new FileChooser("");
        assertAll(
                () -> assertEquals("txt", fileChooser.getExtension("abc.txt")),
                () -> assertEquals("xml", fileChooser.getExtension("abc.xml")),
                () -> assertEquals("bat", fileChooser.getExtension("abc.bat"))
        );
    }
}