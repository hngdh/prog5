package io_utilities.working_with_input;

import enums.Transport;

public class FlatInputChecker extends InputChecker {
    public FlatInputChecker() {
    }

    public static boolean checkName(String name) {
        return checkString(name);
    }

    public static boolean checkCoor(String coor) {
        return checkInteger(coor);
    }

    public static boolean checkArea(String area) {
        return checkInteger(area) && 0 < Long.parseLong(area) && Long.parseLong(area) <= 700;
    }

    public static boolean checkNumberOfRooms(String rooms) {
        return checkInteger(rooms) && Integer.parseInt(rooms) > 0;
    }

    public static boolean checkLivingSpace(String area) {
        return checkInteger(area) && Long.parseLong(area) > 0;
    }

    public static boolean checkCentralHeating(String str) {
        return checkBoolean(str);
    }

    public static boolean checkTransport(String str) {
        if (str == null) {
            return false;
        }
        str = str.toUpperCase();
        try {
            Transport.valueOf(str);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
