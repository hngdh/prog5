package main_objects;

import exceptions.IDTakenException;
import exceptions.LogException;
import exceptions.WrongDataException;
import exceptions.WrongKeyException;
import io_utilities.LogUtil2;
import io_utilities.Printer;
import io_utilities.working_with_csv_file.CSVReader;
import io_utilities.working_with_csv_file.CSVWriter;
import io_utilities.working_with_input.InputChecker;
import io_utilities.working_with_input.InputReader;
import packets.Request;

import java.io.IOException;
import java.util.LinkedList;

public class CollectionManager {
    private final LinkedList<Flat> collection = new LinkedList<>();
    private final String fileName;
    private int id;

    public CollectionManager(String fileName) {
        this.fileName = fileName;
    }

    public void info() {
        Printer.printResult("Type of DS: LinkedList");
        Printer.printResult("Number of elements: " + collection.size());
    }

    public void clear() {
        collection.clear();
    }

    public void show() {
        if (collection.isEmpty()) {
            Printer.printResult("The collection is empty.");
        } else {
            collection.forEach(Flat::printEverything);
        }
    }

    public void sort() {

    }

    public void execute_script() {

    }

    public void min_by_coordinates() {

    }

    public void save() throws LogException {
        try {
            CSVWriter writer = new CSVWriter(fileName);
            for (Flat flat: collection) {
                writer.writeLines(flat.getAllFields());
            }

        } catch (IOException e) {
            LogUtil2.log(e);
            throw new LogException();
        }
    }

    public void add(Request request) {
        Flat flat = request.getFlat();
        collection.add(flat);
    }

    public void filter_contains_name(Request request) {

    }

    public void print_field_ascending_house() {

    }

    public void remove_by_id(Request request) {

    }

    public void remove_first() {

    }

    public void remove_lower(Request request) {

    }

    public void update(Request request) {
        String key = request.getArgument();
        if (key == null || key.isEmpty() || !InputChecker.checkInteger(key)) {
            throw new WrongKeyException();
        } else {
            Flat flat = request.getFlat();
            flat.setId(Integer.parseInt(key));
            collection.remove(key);
            collection.add(flat);
        }
    }

    public void loadData() throws LogException {
        try {
            CSVReader reader = new CSVReader();
            InputReader inputReader = new InputReader();
            inputReader.setReader(fileName);
            String str;
            int counter = 1;
            while ((str = inputReader.readLine()) != null && !str.isEmpty()) {
                try {
                    Flat flat = reader.loadObj(str);
                    String key = flat.getId().toString();
                    if (false) {
                        throw new IDTakenException();
                    } else {
                        collection.add(flat);
                    }
                } catch (WrongDataException e) {
                    Printer.printError("Can't load flat's information on line " + String.valueOf(counter));
                }
                counter++;
            }
        } catch (IOException e) {
            LogUtil2.log(e);
            throw new LogException();
        }
        Printer.printResult("Loaded " + collection.size() + " flat(s) from the file.");
    }
}
