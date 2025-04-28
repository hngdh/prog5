package commands;

import iostream.Receiver;
import packets.Request;

public class Info extends Command {
    private Receiver receiver;

    public Info() {
        super("info", "", "display information about collection");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.info();
    }
}
