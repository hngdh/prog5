import exceptions.LogException;
import io.LogUtil;
import io.Printer;
import iostream.Handler;

public class Main {
    public static void main(String[] args) throws LogException {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            Printer.printError("Uncaught exception in thread: " + t.getName());
            Printer.printError("Error during processing, please check log file.");
            LogUtil.log((Exception) e);
        });
        String fileName = "src\\main\\resources\\data.csv";
        Handler handler = new Handler();
        handler.prepare(fileName);
        handler.run();
    }
}