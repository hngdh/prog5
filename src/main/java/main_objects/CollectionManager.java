package main_objects;

import exceptions.LogException;
import exceptions.UserException;
import exceptions.WrongKeyException;
import io_utilities.Printer;
import io_utilities.working_with_input.InputChecker;
import packets.Request;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

public class CollectionManager {
    private final LinkedHashMap<String, Flat> collection = new LinkedHashMap<>();
    private final String startTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
    private final String fileName;

    public CollectionManager(String fileName) {
        this.fileName = fileName;
    }

    public void info() {
        Printer.printResult("Type of DS: LinkedHashMap");
        Printer.printResult("Moment of initialization: " + startTime);
        Printer.printResult("Number of elements: " + collection.size());
    }

    public void clear() {
        collection.clear();
    }

    public void show() {
        if (collection.isEmpty()) {
            Printer.printInfo("The collection is empty.");
        } else {
            collection.values().forEach(Flat::printEverything);
        }
    }

    public void sort() {

    }

    public void execute_script() {

    }

    public void min_by_coordinates() {

    }

    public void save() throws LogException {

    }

    public void add(Request request) throws UserException {
        String key = request.getArgument();
        if (key == null || key.isEmpty() || !InputChecker.checkInteger(key)) {
            throw new WrongKeyException();
        } else {
            Flat flat = request.getFlat();
            flat.setId(Integer.parseInt(key));
            collection.remove(key);
            collection.put(key, flat);
        }
    }

    public void filter_contains_name(Request request) throws UserException {

    }

    public void print_field_ascending_house() {

    }

    public void remove_by_id(Request request) throws UserException {

    }

    public void remove_first() {

    }

    public void remove_lower(Request request) throws UserException {

    }

    public void update(Request request) throws UserException {
        String key = request.getArgument();
        if (key == null || key.isEmpty() || !InputChecker.checkInteger(key)) {
            throw new WrongKeyException();
        } else {
            Flat flat = request.getFlat();
            flat.setId(Integer.parseInt(key));
            collection.remove(key);
            collection.put(key, flat);
        }
    }
}
