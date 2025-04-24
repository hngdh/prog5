package exceptions;

public class WrongInputException extends RuntimeException {
    public WrongInputException() {
    }

    @Override
    public String toString() {
        return "Wrong input! Please try again.";
    }
}
