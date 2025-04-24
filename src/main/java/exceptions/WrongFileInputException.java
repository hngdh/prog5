package exceptions;

public class WrongFileInputException extends RuntimeException {
    public WrongFileInputException() {
    }

    @Override
    public String toString() {
        return "Wrong file input! Please try again.";
    }
}
