package io_utilities.working_with_csv_file;

import enums.FlatDataTypes;
import enums.HouseDataTypes;
import exceptions.WrongDataException;
import io_utilities.working_with_input.ObjInputChecker;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileProcessor {
    public FileProcessor() {
    }

    public List<String> checkFlatInfo(String str) throws WrongDataException {
        List<String> args = Arrays.asList(str.split(","));
        if (args.size() != 14) {
            throw new WrongDataException();
        }
        List<Boolean> checks = new LinkedList<>();
        checks.add(ObjInputChecker.checkFlatInput(args.get(0), FlatDataTypes.ID));
        checks.add(ObjInputChecker.checkFlatInput(args.get(1), FlatDataTypes.STRING));
        checks.add(ObjInputChecker.checkFlatInput(args.get(2), FlatDataTypes.COORDINATE_X));
        checks.add(ObjInputChecker.checkFlatInput(args.get(3), FlatDataTypes.COORDINATE_Y));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            ZonedDateTime.parse(args.get(4), formatter);
        } catch (DateTimeParseException e) {
            throw new WrongDataException();
        }
        checks.add(ObjInputChecker.checkFlatInput(args.get(5), FlatDataTypes.AREA));
        checks.add(ObjInputChecker.checkFlatInput(args.get(6), FlatDataTypes.ROOMS));
        checks.add(ObjInputChecker.checkFlatInput(args.get(7), FlatDataTypes.SPACE));
        checks.add(ObjInputChecker.checkFlatInput(args.get(8), FlatDataTypes.HEATING));
        checks.add(ObjInputChecker.checkFlatInput(args.get(9), FlatDataTypes.TRANSPORT));
        for (Boolean check : checks) {
            if (!check) {
                throw new WrongDataException();
            }
        }
        return args;
    }

    public List<String> checkHouseInfo(String str) throws WrongDataException {
        List<String> args = Arrays.asList(str.split(","));
        List<Boolean> checks = new LinkedList<>();
        checks.add(ObjInputChecker.checkHouseInput(args.get(10), HouseDataTypes.STRING));
        checks.add(ObjInputChecker.checkHouseInput(args.get(11), HouseDataTypes.YEAR));
        checks.add(ObjInputChecker.checkHouseInput(args.get(12), HouseDataTypes.LIFTS));
        for (boolean check : checks) {
            if (!check) {
                throw new WrongDataException();
            }
        }
        List<String> tmp = new LinkedList<>();
        for (int i = 10; i < args.size(); i++) {
            tmp.add(args.get(i));
        }
        return tmp;
    }
}
