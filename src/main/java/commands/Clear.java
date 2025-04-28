package commands;

import iostream.Receiver;
import packets.Request;

public class Clear extends Command {
    private Receiver receiver;

    public Clear() {
        super("clear", "", "clear collection");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.clear();
    }
}
