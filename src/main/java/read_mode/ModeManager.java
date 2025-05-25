package read_mode;

import exceptions.LogException;
import iostream.Invoker;

import java.util.HashMap;

public class ModeManager {
    private final HashMap<String, ReaderMode> readModes = new HashMap<>();

    public void init() {
        registerReadMode("execute_script", new FileReaderMode());
        registerReadMode("remove_lower", new ConsoleReaderMode());
        registerReadMode("update", new ConsoleReaderMode());
        registerReadMode("add", new ConsoleReaderMode());
    }

    public void registerReadMode(String command, ReaderMode readMode) {
        readModes.put(command, readMode);
    }

    public void call(Invoker invoker, String commandName, String arg) throws LogException {
        readModes.get(commandName).executeMode(invoker, commandName, arg);
    }
}
