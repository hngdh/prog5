package commands;

import iostream.Receiver;
import packets.Request;

public class Print_field_ascending_house extends Command {
    private Receiver receiver;

    public Print_field_ascending_house() {
        super("print_field_ascending_house", "", "display in ascending order all elements in house's field");
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) {
        receiver.print_field_ascending_house();
    }
}
