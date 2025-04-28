package exceptions;

public class WrongCommandException extends RuntimeException {
    public WrongCommandException() {
    }

    @Override
    public String toString() {
        return "Wrong command!";
    }
}
