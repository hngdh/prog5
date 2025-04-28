package exceptions;

public class WrongInputFormatException extends Exception {
    public WrongInputFormatException() {
    }

    @Override
    public String toString() {
        return "Wrong input format!";
    }
}