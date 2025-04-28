package commands;

import iostream.Receiver;
import packets.Request;

public class Help extends Command {
    private Receiver receiver;

    public Help() {
        super("help", "", "display this dialog");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.help();
    }
}
