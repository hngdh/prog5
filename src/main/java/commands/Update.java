package commands;

import iostream.Receiver;
import packets.Request;

public class Update extends Command {
    private Receiver receiver;

    public Update() {
        super("update", "id {element}", "update value of element with given id");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.update(request);
    }
}
