package iostream;

import command_utilities.CommandManager;
import commands.Command;
import exceptions.LogException;
import io.Printer;
import packets.Request;

public class Invoker {
    private final CommandManager commandManager;
    private final Receiver receiver;

    public Invoker(CommandManager commandManager, Receiver receiver) {
        this.commandManager = commandManager;
        this.receiver = receiver;
    }

    public void call(String command, Request request) throws LogException {
        Printer.printCondition("> Executing " + command);
        Command cmd = commandManager.getCommand(command);
        cmd.setReceiver(receiver);
        cmd.execute(request);
    }
}
