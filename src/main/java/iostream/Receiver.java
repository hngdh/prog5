package iostream;

import cmd_utilities.CmdManager;
import exceptions.LogException;
import exceptions.UserException;
import io_utilities.Printer;
import main_objects.CollectionManager;
import packets.Request;

public class Receiver {
    private final CollectionManager collectionManager;
    private final CmdManager cmdManager;

    public Receiver(CollectionManager collectionManager, CmdManager cmdManager) {
        this.cmdManager = cmdManager;
        this.collectionManager = collectionManager;
    }

    public void exit() {
        System.exit(0);
    }

    public void help() {
        cmdManager.getCommandCollection().forEach((name, command) -> {
            command.getCommandInfo();
        });
    }

    public void clear() {
        collectionManager.clear();
    }

    public void info() {
        collectionManager.clear();
    }

    public void show() {
        collectionManager.show();
    }

    public void sort() {
        collectionManager.sort();
    }

    public void execute_script() {
        Printer.printCondition("File being executed...");
    }

    public void min_by_coordinates() {
        collectionManager.min_by_coordinates();
    }

    public void save() throws LogException {
        collectionManager.save();
    }

    public void add(Request request) throws UserException {
        collectionManager.add(request);
    }

    public void filter_contains_name(Request request) throws UserException {
        collectionManager.filter_contains_name(request);
    }

    public void print_field_ascending_house() {
        collectionManager.print_field_ascending_house();
    }

    public void remove_by_id(Request request) throws UserException {
        collectionManager.remove_by_id(request);
    }

    public void remove_first() {
        collectionManager.remove_first();
    }

    public void remove_lower(Request request) throws UserException {
        collectionManager.remove_lower(request);
    }

    public void update(Request request) throws UserException {
        collectionManager.update(request);
    }
}
