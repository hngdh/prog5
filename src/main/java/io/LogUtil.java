package io;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil {
    private static final Logger log = Logger.getLogger(LogUtil.class.getName());

    private LogUtil() {
    }

    public static void log(Exception e) {
        log.log(Level.SEVERE, "", e);
    }
}
