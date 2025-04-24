package commands;

import exceptions.UserException;
import iostream.Receiver;
import packets.Request;

public class Update extends Command {
    private Receiver receiver;

    public Update() {
        super("update", "id", "{element}", "update value of element with given id");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) throws UserException {
        receiver.update(request);
    }
}
