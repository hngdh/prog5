package commands;

import exceptions.LogException;
import exceptions.UserException;
import iostream.Receiver;
import packets.Request;

public abstract class Command {
    //Name of the command
    private final String name;

    //Parameters of the command, empty string if no arguments needed
    private final String argument;
    private final String argument2;

    //Command's description
    private final String description;

    public Command(String name, String argument, String argument2, String description) {
        this.name = name;
        this.argument = argument;
        this.argument2 = argument2;
        this.description = description;
    }

    public abstract void setReceiver(Receiver receiver);

    public abstract void execute(Request request) throws UserException, LogException;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getArgument() {
        return argument;
    }

    public String getArgument2() {
        return argument2;
    }

    public void getCommandInfo() {

    }
}
