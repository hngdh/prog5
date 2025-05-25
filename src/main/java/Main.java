import exceptions.LogException;
import iostream.Handler;

public class Main {
    public static void main(String[] args) throws LogException {
        String fileName = "src\\main\\resources\\data.csv";
        Handler handler = new Handler();
        handler.prepare(fileName);
        handler.run();
    }
}