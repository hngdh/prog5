package io_utilities.working_with_input;

import enums.CommandFormats;
import exceptions.InputFormatException;

import java.util.HashMap;

public class FormatChecker {
    private final HashMap<String, CommandFormats> commandFormatsHashMap = new HashMap<>();

    public FormatChecker() {
    }

    public void init() {

    }

    public void registerCommandFormat(String command, CommandFormats format) {
        commandFormatsHashMap.put(command, format);
    }

    public void checkFormat(String command, String argument) throws InputFormatException {
        if (!commandFormatsHashMap.containsKey(command)) throw new InputFormatException();
        CommandFormats commandFormats = commandFormatsHashMap.get(command);
        switch (commandFormats) {
            case WITH_NUMERAL_ARG:
                try {
                    int integer = Integer.parseInt(argument);
                    if (integer < 0) {
                        throw new InputFormatException();
                    }
                } catch (NumberFormatException e) {
                    throw new InputFormatException();
                }
                break;
            case WITH_STRING_ARG:
                if (argument == null || argument.isEmpty()) throw new InputFormatException();
                break;
            case WITHOUT_ARG:
                if (argument != null && argument.isEmpty()) throw new InputFormatException();
                break;
        }
    }
}
