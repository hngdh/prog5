package io_utilities.working_with_input;

import enums.CommandFormats;
import exceptions.WrongInputFormatException;

import java.util.HashMap;

public class FormatChecker {
    private final HashMap<String, CommandFormats> commandFormatsHashMap = new HashMap<>();

    public FormatChecker() {
    }

    public void init() {
        registerCommandFormat("add", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("clear", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("execute_script", CommandFormats.WITH_STRING_ARG);
        registerCommandFormat("exit", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("filter_contains_name", CommandFormats.WITH_STRING_ARG);
        registerCommandFormat("help", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("info", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("min_by_coordinates", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("print_field_ascending_house", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("remove_by_id", CommandFormats.WITH_NUMERAL_ARG);
        registerCommandFormat("remove_first", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("remove_lower", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("save", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("show", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("sort", CommandFormats.WITHOUT_ARG);
        registerCommandFormat("update", CommandFormats.WITH_NUMERAL_ARG);
    }

    public void registerCommandFormat(String command, CommandFormats format) {
        commandFormatsHashMap.put(command, format);
    }

    public void checkFormat(String command, String argument) throws WrongInputFormatException {
        if (!commandFormatsHashMap.containsKey(command)) throw new WrongInputFormatException();
        CommandFormats commandFormats = commandFormatsHashMap.get(command);
        switch (commandFormats) {
            case WITH_NUMERAL_ARG:
                try {
                    int integer = Integer.parseInt(argument);
                    if (integer < 0) {
                        throw new WrongInputFormatException();
                    }
                } catch (NumberFormatException e) {
                    throw new WrongInputFormatException();
                }
                break;
            case WITH_STRING_ARG:
                if (argument == null || argument.isEmpty()) throw new WrongInputFormatException();
                break;
            case WITHOUT_ARG:
                if (argument != null && !argument.isEmpty()) throw new WrongInputFormatException();
                break;
        }
    }
}
