package commands;

import iostream.Receiver;
import packets.Request;

public class Remove_first extends Command {
    private Receiver receiver;

    public Remove_first() {
        super("remove_first", "", "", "remove first element in collection");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.remove_first();
    }
}
