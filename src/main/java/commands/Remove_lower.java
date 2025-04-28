package commands;

import iostream.Receiver;
import packets.Request;

public class Remove_lower extends Command {
    private Receiver receiver;

    public Remove_lower() {
        super("remove_lower", "{element}", "remove elements lower than given element");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.remove_lower(request);
    }
}
