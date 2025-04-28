package io_utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil2 {
    private static Logger log = Logger.getLogger(LogUtil2.class.getName());

    private LogUtil2() {
    }

    public static void log(Exception e) {
        log.log(Level.SEVERE, "", e);
    }
}
