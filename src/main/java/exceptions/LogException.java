package exceptions;

public class LogException extends Exception {
    public LogException() {
    }

    @Override
    public String toString() {
        return "Error during processing, please check log file.";
    }
}
