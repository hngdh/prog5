package commands;

import iostream.Receiver;
import packets.Request;

public class Min_by_coordinates extends Command {
    private Receiver receiver;

    public Min_by_coordinates() {
        super("clear", "", "display object from collection with minimum coordinate");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.min_by_coordinates();
    }
}
