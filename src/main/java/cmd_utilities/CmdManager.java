package cmd_utilities;

import commands.*;

import java.util.HashMap;

public class CmdManager {
    private final HashMap<String, Command> commandCollection = new HashMap<>();

    public CmdManager() {
    }

    public void init() {
        registerCommand("add", new Add());
        registerCommand("clear", new Clear());
        registerCommand("execute_script", new Execute_script());
        registerCommand("exit", new Exit());
        registerCommand("filter_contains_name", new Filter_contains_name());
        registerCommand("help", new Help());
        registerCommand("info", new Info());
        registerCommand("min_by_coordinates", new Min_by_coordinates());
        registerCommand("print_field_ascending_house", new Print_field_ascending_house());
        registerCommand("remove_by_id", new Remove_by_id());
        registerCommand("remove_first", new Remove_first());
        registerCommand("remove_lower", new Remove_lower());
        registerCommand("save", new Save());
        registerCommand("show", new Show());
        registerCommand("sort", new Sort());
        registerCommand("update", new Update());
    }

    public void registerCommand(String name, Command command) {
        commandCollection.put(name, command);
    }

    public Command getCommand(String commandName) {
        return commandCollection.get(commandName);
    }

    public HashMap<String, Command> getCommandCollection() {
        return commandCollection;
    }

    public boolean isCommand(String commandName) {
        return commandCollection.containsKey(commandName);
    }
}
