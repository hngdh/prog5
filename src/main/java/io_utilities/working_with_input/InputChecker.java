package io_utilities.working_with_input;

import exceptions.WrongInputException;
import io_utilities.LogUtil;
import io_utilities.Printer;

import java.io.IOException;

public class InputChecker {
    public static boolean checkInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        if (input.trim() != input) {
            return false;
        }
        if (input.matches(" ( )+")) {
            return false;
        }
        return !input.contains("\t");
    }

    public static boolean checkString(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        input = input.trim();
        return !input.isEmpty();
    }

    public static boolean checkInteger(String input) {
        return input.matches("-?[0-9]+");
    }

    public static boolean checkBoolean(String input) {
        return input.toLowerCase().strip() == "false" || input.toLowerCase().strip() == "true";
    }

    public static boolean checkOptional(String act, String description) {
        try {
            Printer.printInfo("Do you want to" + act + description + "? (yes/no)");
            InputReader inputReader = new InputReader();
            inputReader.setReader();
            String input = "";
            while (input.isEmpty()) {
                input = inputReader.readLine();
                if (input.equalsIgnoreCase("yes")) {
                    return true;
                } else if (input.equalsIgnoreCase("no")) {
                    return false;
                } else {
                    try {
                        throw new WrongInputException();
                    } catch (WrongInputException e) {
                        input = "";
                        Printer.printError(inputReader.toString());
                    }
                }
            }
        } catch (IOException e) {
            LogUtil.log(e);
        }
        return false;
    }
}
