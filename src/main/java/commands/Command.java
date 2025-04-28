package commands;

import exceptions.LogException;
import iostream.Receiver;
import packets.Request;

public abstract class Command {
    //Name of the command
    private final String name;

    //Parameters of the command, empty string if no arguments needed
    private final String argument;

    //Command's description
    private final String description;

    public Command(String name, String argument, String description) {
        this.name = name;
        this.argument = argument;
        this.description = description;
    }

    public abstract void setReceiver(Receiver receiver);

    public abstract void execute(Request request) throws LogException;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getArgument() {
        return argument;
    }

    public String getCommandInfo() {
        return (name + " " + argument).trim() + ": " + description;
    }
}
