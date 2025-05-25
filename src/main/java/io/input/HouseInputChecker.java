package io.input;

public class HouseInputChecker extends InputChecker {
    public HouseInputChecker() {
    }

    public static boolean checkName(String name) {
        return checkString(name);
    }

    public static boolean checkYear(String year) {
        return checkInteger(year) && Integer.parseInt(year) > 0;
    }

    public static boolean checkNumberOfLifts(String lifts) {
        return checkInteger(lifts) && Integer.parseInt(lifts) > 0;
    }
}
