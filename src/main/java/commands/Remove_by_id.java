package commands;

import iostream.Receiver;
import packets.Request;

public class Remove_by_id extends Command {
    private Receiver receiver;

    public Remove_by_id() {
        super("remove_by_id", "id", "remove element from collection by its id");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.remove_by_id(request);
    }
}
