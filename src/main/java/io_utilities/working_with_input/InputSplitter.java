package io_utilities.working_with_input;

public class InputSplitter {
    public InputSplitter() {
    }

    public static String getCommand(String input) {
        return input.split(" ")[0];
    }

    public static String getArg(String input) {
        if (input.split(" ").length >= 2) {
            return input.split(" ")[1];
        } else {
            return null;
        }
    }
}
