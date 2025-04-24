package exceptions;

public class InputFormatException extends Exception {
    public InputFormatException() {
    }

    @Override
    public String toString() {
        return "Input format is wrong! Please try again.";
    }
}
