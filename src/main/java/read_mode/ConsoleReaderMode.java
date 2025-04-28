package read_mode;

import enums.FlatDataTypes;
import enums.HouseDataTypes;
import exceptions.LogException;
import exceptions.WrongInputException;
import io_utilities.LogUtil2;
import io_utilities.Printer;
import io_utilities.working_with_input.Builder;
import io_utilities.working_with_input.InputChecker;
import io_utilities.working_with_input.InputReader;
import io_utilities.working_with_input.ObjInputChecker;
import iostream.Invoker;
import main_objects.Flat;
import packets.Request;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class ConsoleReaderMode implements ReadMode {
    public ConsoleReaderMode() {
    }

    public Flat build(InputReader reader) throws LogException {
        List<String> flatInfo = new LinkedList<>();
        List<String> houseInfo = new LinkedList<>();

        try {
            Printer.printInfo("Please type flat info");
            flatInfo.add("0");
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.STRING, "Flat's name:", "must not be empty"));
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.COORDINATE_X, "Flat's X coordinate:", "must not be empty"));
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.COORDINATE_Y, "Flat's Y coordinate:", "must not be empty"));
            flatInfo.add(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.AREA, "Flat's area:", "must not be empty and less than 700"));
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.ROOMS, "Flat's number of rooms:", "must not be empty"));
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.SPACE, "Flat's living space:", "must not be empty"));
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.HEATING, "Flat's existence of central heating:", "must not be empty"));
            flatInfo.add(getFlatUserInput(reader, FlatDataTypes.TRANSPORT, "Flat's local transport:", "must not be empty"));
            if (InputChecker.checkOptional("insert", "house's details?")) {
                Printer.printInfo("Please type house info");
                houseInfo.add(getHouseUserInput(reader, HouseDataTypes.STRING, "House's name:", "must not be empty"));
                houseInfo.add(getHouseUserInput(reader, HouseDataTypes.YEAR, "House's construction year:", "must not be empty and positive number"));
                houseInfo.add(getHouseUserInput(reader, HouseDataTypes.LIFTS, "House's number of lifts:", "must not be empty and positive number"));
            } else {
                for (int i = 0; i < 3; i++) {
                    houseInfo.add("null");
                }
            }
        } catch (IOException e) {
            LogUtil2.log(e);
            throw new LogException();
        }
        return Builder.buildFlat(flatInfo, houseInfo);
    }

    public String getFlatUserInput(InputReader reader, FlatDataTypes dataType, String description, String condition) throws IOException {
        boolean check = false;
        String temp = "";
        while (!check) {
            Printer.printCondition(description + '(' + condition + ')');
            try {
                String str = reader.readLine();
                check = ObjInputChecker.checkFlatInput(str, dataType);
                if (check) {
                    if (str == null || str.isEmpty()) {
                        temp = "null";
                    } else {
                        temp = str;
                    }
                    break;
                } else {
                    throw new WrongInputException();
                }
            } catch (WrongInputException e) {
                Printer.printError(e.toString());
            }
        }
        return temp;
    }

    public String getHouseUserInput(InputReader reader, HouseDataTypes dataType, String description, String condition) throws IOException {
        boolean check = false;
        String temp = "";
        while (!check) {
            Printer.printCondition(description + '(' + condition + ')');
            try {
                String str = reader.readLine();
                check = ObjInputChecker.checkHouseInput(str, dataType);
                if (check) {
                    if (str == null || str.isEmpty()) {
                        temp = "null";
                    } else {
                        temp = str;
                    }
                    break;
                } else {
                    throw new WrongInputException();
                }
            } catch (WrongInputException e) {
                Printer.printError(e.toString());
            }
        }
        return temp;
    }

    @Override
    public void executeMode(Invoker invoker, String commandName, String arg) throws LogException {
        InputReader reader = new InputReader();
        reader.setReader();
        Request request = new Request(arg, build(reader));
        invoker.call(commandName, request);
    }
}
