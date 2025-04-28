package iostream;

import cmd_utilities.CmdClassifier;
import cmd_utilities.CmdManager;
import enums.CommandTypes;
import exceptions.LogException;
import exceptions.WrongInputFormatException;
import io_utilities.LogUtil2;
import io_utilities.Printer;
import io_utilities.working_with_input.FormatChecker;
import io_utilities.working_with_input.InputChecker;
import io_utilities.working_with_input.InputReader;
import io_utilities.working_with_input.InputSplitter;
import main_objects.CollectionManager;
import packets.Request;
import read_mode.ModeManager;

import java.io.IOException;

public class Handler {
    private InputReader inputReader;
    private CmdClassifier cmdClassifier;
    private ModeManager modeManager;
    private Invoker invoker;
    private FormatChecker formatChecker;

    public Handler() {
        Printer.printInfo("This program helps you managing flats' information");
        Printer.printInfo("Type 'help' to get full instructions");
        Printer.printInfo("Type 'exit' to exit program");
    }

    public void prepare(String fileName) {
        try {
            inputReader = new InputReader();
            inputReader.setReader();
            formatChecker = new FormatChecker();
            formatChecker.init();
            cmdClassifier = new CmdClassifier();
            cmdClassifier.init();

            modeManager = new ModeManager();
            modeManager.init();
            CmdManager cmdManager = new CmdManager();
            cmdManager.init();
            CollectionManager collectionManager = new CollectionManager(fileName);

            Receiver receiver = new Receiver(collectionManager, cmdManager);
            invoker = new Invoker(cmdManager, receiver);

            collectionManager.loadData();
        } catch (LogException e) {
            Printer.printError(e.toString());
        }
    }

    public void run() {
        while (true) {
            try {
                String input = inputReader.readLine();
                input = input.trim();
                preprocess(input);
                process(input);
                Printer.printInfo("Executed.");
            } catch (LogException | WrongInputFormatException e) {
                Printer.printError(e.toString());
                Printer.printCondition("Command couldn't be executed!");
            } catch (IOException e) {
                LogUtil2.log(e);
            }
        }
    }

    public void preprocess(String input) throws WrongInputFormatException {
        if (!InputChecker.checkInput(input)) {
            throw new WrongInputFormatException();
        }
        formatChecker.checkFormat(InputSplitter.getCommand(input), InputSplitter.getArg(input));
    }

    public void process(String input) throws LogException {
        String command = InputSplitter.getCommand(input);
        String argument = InputSplitter.getArg(input);
        CommandTypes type = cmdClassifier.getCommandClassifier(command);
        switch (type) {
            case INPUT_NEEDED -> modeManager.call(invoker, command, argument);
            case NO_INPUT_NEEDED -> invoker.call(command, new Request(argument, null));
        }
    }
}
