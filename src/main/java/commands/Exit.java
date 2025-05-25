package commands;

import enums.CommandFormats;
import enums.CommandTypes;
import exceptions.LogException;
import iostream.Receiver;
import packets.Request;

public class Exit extends Command {
    private Receiver receiver;

    public Exit() {
        super("exit", "", "exit the program (without saving)", CommandTypes.NO_INPUT_NEEDED, CommandFormats.WITHOUT_ARG);
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Request request) throws LogException {
        receiver.exit();
    }
}
