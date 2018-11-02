package info.snakea.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil {

    private static final String LOGGER_PATH = "./results/iati_generator.log";
    private static final Level LOGGER_LEVEL = Level.INFO;

    static final Logger LOGGER = Logger.getLogger(LogUtil.class.getName());

    static {
        try {
            Handler fileHandler  = new FileHandler(LOGGER_PATH);
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(LOGGER_LEVEL);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }

    }

    private LogUtil() {
        super();
    }
}
