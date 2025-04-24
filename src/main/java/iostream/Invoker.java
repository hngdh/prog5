package iostream;

import cmd_utilities.CmdManager;
import commands.Command;
import exceptions.LogException;
import exceptions.UserException;
import io_utilities.Printer;
import packets.Request;

public class Invoker {
    private final CmdManager cmdManager;
    private final Receiver receiver;

    public Invoker(CmdManager cmdManager, Receiver receiver) {
        this.cmdManager = cmdManager;
        this.receiver = receiver;
    }

    public void call(String command, Request request) throws UserException, LogException {
        Printer.printCondition("> Executing " + command);
        Command cmd = cmdManager.getCommand(command);
        cmd.setReceiver(receiver);
        cmd.execute(request);
    }
}
