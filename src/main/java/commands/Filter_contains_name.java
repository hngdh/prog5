package commands;

import iostream.Receiver;
import packets.Request;

public class Filter_contains_name extends Command {
    private Receiver receiver;

    public Filter_contains_name() {
        super("filter_contains_name", "name", "display elements with given name");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.filter_contains_name(request);
    }
}