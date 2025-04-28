package exceptions;

public class WrongDataException extends Exception {
    public WrongDataException() {
    }

    @Override
    public String toString() {
        return "There were problems loading data.";
    }
}
