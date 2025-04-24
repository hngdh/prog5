package io_utilities.working_with_input;

import enums.FlatDataTypes;
import enums.HouseDataTypes;

public class ObjInputChecker {
    public ObjInputChecker() {
    }

    public static boolean checkFlatInput(String str, FlatDataTypes type) {
        return switch (type) {
            case ID -> str.matches("[0-9]+");
            case STRING -> FlatInputChecker.checkName(str);
            case COORDINATE_X, COORDINATE_Y -> FlatInputChecker.checkCoor(str);
            case AREA -> FlatInputChecker.checkArea(str);
            case ROOMS -> FlatInputChecker.checkNumberOfRooms(str);
            case SPACE -> FlatInputChecker.checkLivingSpace(str);
            case HEATING -> FlatInputChecker.checkCentralHeating(str);
            case TRANSPORT -> FlatInputChecker.checkTransport(str);
        };
    }

    public static boolean checkHouseInput(String str, HouseDataTypes type) {
        return switch (type) {
            case STRING -> HouseInputChecker.checkString(str);
            case YEAR -> HouseInputChecker.checkYear(str);
            case LIFTS -> HouseInputChecker.checkNumberOfLifts(str);
        };
    }
}
