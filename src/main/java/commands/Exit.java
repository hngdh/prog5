package commands;

import iostream.Receiver;
import packets.Request;

public class Exit extends Command {
    private Receiver receiver;

    public Exit() {
        super("exit", "", "exit the program (without saving)");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.exit();
    }
}
