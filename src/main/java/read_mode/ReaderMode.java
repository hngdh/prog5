package read_mode;

import exceptions.LogException;
import iostream.Invoker;

public interface ReaderMode {
    void executeMode(Invoker invoker, String commandName, String arg) throws LogException;

}
