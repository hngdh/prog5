package iostream;

import cmd_utilities.CmdClassifier;
import cmd_utilities.CmdManager;
import enums.CommandTypes;
import exceptions.*;
import io_utilities.LogUtil;
import io_utilities.Printer;
import io_utilities.working_with_input.InputChecker;
import io_utilities.working_with_input.InputReader;
import io_utilities.working_with_input.InputSplitter;
import io_utilities.working_with_input.FormatChecker;
import main_objects.CollectionManager;
import packets.Request;
import read_mode.ModeManager;

import java.io.IOException;

public class Handler {
    private InputReader inputReader;
    private CollectionManager collectionManager;
    private CmdClassifier cmdClassifier;
    private CmdManager cmdManager;
    private ModeManager modeManager;
    private Receiver receiver;
    private Invoker invoker;
    private FormatChecker formatChecker;

    public Handler() {
        Printer.printInfo("This program helps you managing flats' information");
        Printer.printInfo("Type 'help' to get full instructions");
        Printer.printInfo("Type 'exit' to exit program");
    }

    public void prepare(String fileName) {
        inputReader = new InputReader();
        inputReader.setReader();
        cmdClassifier = new CmdClassifier();
        cmdClassifier.init();

        modeManager = new ModeManager();
        modeManager.init();
        cmdManager = new CmdManager();
        cmdManager.init();
        collectionManager = new CollectionManager(fileName);

        receiver = new Receiver(collectionManager, cmdManager);
        invoker = new Invoker(cmdManager, receiver);


        Printer.printInfo("Data loaded successfully!");
    }

    public void run() {
        while (true) {
            try {
                String input = inputReader.readLine();
                input = input.trim();
                preprocess(input);
                process(input);
            } catch (UserException | LogException | InputFormatException e) {
                Printer.printError(e.toString());
                Printer.printCondition("Command couldn't be executed!");
            } catch (IOException e) {
                LogUtil.log(e);
            }
        }
    }

    public void preprocess(String input) throws InputFormatException {
        if (!InputChecker.checkInput(input)) {
            throw new InputFormatException();
        }
    formatChecker.checkFormat(InputSplitter.getCommand(input),InputSplitter.getArg(input));
    }

    public void process(String input) throws UserException, LogException {
        String command = InputSplitter.getCommand(input);
        String argument = InputSplitter.getArg(input);
        CommandTypes type = cmdClassifier.getCommandClassifier(command);
        switch (type) {
            case INPUT_NEEDED -> modeManager.call(invoker, command, argument);
            case NO_INPUT_NEEDED -> invoker.call(command, new Request(argument, null));
        }
    }
}
