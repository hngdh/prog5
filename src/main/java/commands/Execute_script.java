package commands;

import iostream.Receiver;
import packets.Request;

public class Execute_script extends Command {
    private Receiver receiver;

    public Execute_script() {
        super("execute_script", "file_name", "read and execute script from file. Commands in the script formatted the same as in interactive mode");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.execute_script();
    }
}
