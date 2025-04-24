package read_mode;

import exceptions.LogException;
import exceptions.UserException;
import iostream.Invoker;

import java.util.HashMap;

public class ModeManager {
    private final HashMap<String, ReadMode> readModes = new HashMap<>();

    public void init() {
        registerReadMode("execute_script", new FileReaderMode());
        registerReadMode("remove_by_id", new ConsoleReaderMode());
        registerReadMode("remove_first", new ConsoleReaderMode());
        registerReadMode("remove_lower", new ConsoleReaderMode());
        registerReadMode("update", new ConsoleReaderMode());
    }

    public void registerReadMode(String command, ReadMode readMode) {
        readModes.put(command, readMode);
    }

    public void call(Invoker invoker, String commandName, String arg) throws UserException, LogException {
        readModes.get(commandName).executeMode(invoker, commandName, arg);
    }
}
