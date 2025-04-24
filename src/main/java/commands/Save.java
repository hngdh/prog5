package commands;

import exceptions.LogException;
import iostream.Receiver;
import packets.Request;

public class Save extends Command {
    private Receiver receiver;

    public Save() {
        super("save", "", "", "save collection to file");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) throws LogException {
        receiver.save();
    }
}
