package exceptions;

public class WrongKeyException extends RuntimeException {
    public WrongKeyException() {
    }

    @Override
    public String toString() {
        return "Wrong key or key is not listed!";
    }
}
