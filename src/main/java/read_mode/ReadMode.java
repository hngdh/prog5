package read_mode;

import exceptions.LogException;
import exceptions.UserException;
import iostream.Invoker;

public interface ReadMode {
    void executeMode(Invoker invoker, String commandName, String arg) throws UserException, LogException;

}
