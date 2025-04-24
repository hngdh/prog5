package packets;

import main_objects.Flat;

public class Request {
    private final String argument;
    private final Flat flat;

    public Request(String argument, Flat flat) {
        this.argument = argument;
        this.flat = flat;
    }

    public String getArgument() {
        return argument;
    }

    public Flat getFlat() {
        return flat;
    }
}
