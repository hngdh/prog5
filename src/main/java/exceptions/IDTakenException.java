package exceptions;

public class IDTakenException extends RuntimeException {
    public IDTakenException() {
    }

    @Override
    public String toString() {
        return "ID taken, please choose another one.";
    }
}
