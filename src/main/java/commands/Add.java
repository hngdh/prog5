package commands;

import exceptions.UserException;
import iostream.Receiver;
import packets.Request;

public class Add extends Command {
    private Receiver receiver;

    public Add() {
        super("add", "{element}", "", "add element to collection");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) throws UserException {
        receiver.add(request);
    }
}
