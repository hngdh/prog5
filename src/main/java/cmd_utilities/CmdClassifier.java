package cmd_utilities;

import enums.CommandTypes;

import java.util.HashMap;

public class CmdClassifier {
    private final HashMap<String, CommandTypes> commandClassifier = new HashMap<>();

    public void init() {
        addClassifier("help", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("info", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("show", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("clear", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("save", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("exit", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("remove_first", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("sort", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("min_by_coordinates", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("print_field_ascending_house", CommandTypes.NO_INPUT_NEEDED);
        addClassifier("add", CommandTypes.INPUT_NEEDED);
        addClassifier("update", CommandTypes.INPUT_NEEDED);
        addClassifier("remove_by_id", CommandTypes.INPUT_NEEDED);
        addClassifier("execute_script", CommandTypes.INPUT_NEEDED);
        addClassifier("remove_lower", CommandTypes.INPUT_NEEDED);
        addClassifier("filter_contains_name", CommandTypes.INPUT_NEEDED);
    }

    public void addClassifier(String command, CommandTypes type) {
        commandClassifier.put(command, type);
    }

    public CommandTypes getCommandClassifier(String command) {
        return commandClassifier.get(command);
    }
}
