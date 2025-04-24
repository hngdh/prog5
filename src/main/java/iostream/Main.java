package iostream;

import io_utilities.LogUtil;
import io_utilities.Printer;

public class Main {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t,e) -> {
            Printer.printError("Uncaught exception in thread: " + t.getName());
            Printer.printError("Error during processing, please check log file.");
            LogUtil.log(e);
        });
        Handler handler = new Handler();
        handler.prepare("");
        handler.run();
    }
}