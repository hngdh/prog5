package read_mode;

import cmd_utilities.CmdClassifier;
import cmd_utilities.CmdManager;
import enums.CommandTypes;
import enums.FlatDataTypes;
import enums.HouseDataTypes;
import exceptions.*;
import io_utilities.LogUtil;
import io_utilities.Printer;
import io_utilities.working_with_input.*;
import iostream.Invoker;
import main_objects.Flat;
import packets.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderMode implements ReadMode {
    private final CmdManager commandManager;
    private final CmdClassifier commandClassifier;

    public FileReaderMode() {
        commandClassifier = new CmdClassifier();
        commandManager = new CmdManager();
        commandManager.init();
        commandManager.init();
    }

    public Flat build(InputReader reader) throws UserException, LogException {
        List<String> flatInfo = new ArrayList<>();
        List<String> houseInfo = new ArrayList<>();
        flatInfo.add("0");

        try {
            Printer.printInfo("Please type flat info");
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.STRING));
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.COORDINATE_X));
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.COORDINATE_Y));
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.AREA));
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.ROOMS));
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.SPACE));
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.HEATING));
            flatInfo.add(getFlatFileInput(reader, FlatDataTypes.TRANSPORT));
            houseInfo.add(getHouseFileInput(reader, HouseDataTypes.STRING));
            houseInfo.add(getHouseFileInput(reader, HouseDataTypes.YEAR));
            houseInfo.add(getHouseFileInput(reader, HouseDataTypes.LIFTS));
        } catch (IOException e) {
            LogUtil.log(e);
            throw new LogException();
        }
        return Builder.buildFlat(flatInfo, houseInfo);
    }

    public String getFlatFileInput(InputReader reader, FlatDataTypes dataType) throws IOException, UserException {
        String str = reader.readLine();
        boolean check = ObjInputChecker.checkFlatInput(str, dataType);
        if (check) {
            return str;
        } else {
            throw new WrongInputException();
        }
    }

    public String getHouseFileInput(InputReader reader, HouseDataTypes dataType) throws IOException, UserException {
        String str = reader.readLine();
        boolean check = ObjInputChecker.checkHouseInput(str, dataType);
        if (check) {
            return str;
        } else {
            throw new WrongInputException();
        }
    }

    public String getNextCommand(InputReader reader) throws IOException, UserException, LogException {
        String input = reader.readLine();
        if (input != null || input.isEmpty()) return null;
        if (!InputChecker.checkInput(input)) {
            throw new WrongFileInputException();
        }
        if (!commandManager.isCommand(InputSplitter.getCommand(input.toLowerCase()))) {
            throw new WrongCommandException();
        }
        return input;
    }

    public void process(String currentFile, Invoker invoker) throws UserException, LogException, IOException {
        try {
            invoker.call("execute_script", new Request(null, null));
            InputReader inputReader = new InputReader();
            inputReader.setReader(currentFile);
            String input;
            while ((input = getNextCommand(inputReader)) != null) {
                String nameNewCommand = InputSplitter.getCommand(input);
                String argument = InputSplitter.getArg(input);
                CommandTypes commandType = commandClassifier.getCommandClassifier(nameNewCommand);
                Printer.printCondition("--- Current file: " + currentFile + " ---");
                switch (commandType) {
                    case NO_INPUT_NEEDED -> invoker.call(nameNewCommand, new Request(argument, null));
                    case INPUT_NEEDED -> {
                        if (!nameNewCommand.equals("execute_script")) {
                            Flat flat = build(inputReader);
                            try {
                                invoker.call(nameNewCommand, new Request(argument, flat));
                            } catch (IDTakenException e) {
                                Printer.printError(e.toString());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            LogUtil.log(e);
            throw new LogException();
        }
    }

    @Override
    public void executeMode(Invoker invoker, String commandName, String arg) throws UserException, LogException {
    }
}
