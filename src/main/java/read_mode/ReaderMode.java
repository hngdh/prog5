package read_mode;

import exceptions.LogException;
import iostream.Invoker;

import java.io.IOException;

public interface ReaderMode {
    void executeMode(Invoker invoker, String commandName, String arg) throws LogException, IOException;

}
