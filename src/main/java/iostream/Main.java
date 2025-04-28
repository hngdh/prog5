package iostream;

public class Main {
    public static void main(String[] args) {
//        Thread.setDefaultUncaughtExceptionHandler((t,e) -> {
//            Printer.printError("Uncaught exception in thread: " + t.getName());
//            Printer.printError("Error during processing, please check log file.");
//            LogUtil2.log((Exception) e);
//        });
        Handler handler = new Handler();
        handler.prepare("src\\main\\java\\data\\data.csv");
        handler.run();
    }
}