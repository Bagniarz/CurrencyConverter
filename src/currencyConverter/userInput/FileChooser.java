package currencyConverter.userInput;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class FileChooser {

    final private String arg;

    public FileChooser(String arg) {
        this.arg = arg;
    }

    public boolean isPath(String arg) {
        try {
            Paths.get(arg);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    public boolean isArg(String arg) {
        if (arg == null || arg.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidExtension(String path) {
        if (path.contains(".txt") || path.contains(".xml")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidPath(FileChooser fileChooser) {
        return fileChooser.isArg(fileChooser.getArg())
                && fileChooser.isPath(fileChooser.getArg())
                && fileChooser.isValidExtension(fileChooser.getArg());
    }

    public String getExtension(String path) {
        return path.substring(path.lastIndexOf('.') + 1);
    }

    public String getArg() {
        return arg;
    }
}
