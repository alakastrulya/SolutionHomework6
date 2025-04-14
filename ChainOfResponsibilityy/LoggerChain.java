package ChainOfResponsibilityy;

import java.util.ArrayList;
import java.util.List;

public class LoggerChain {
    private List<Logger> loggers = new ArrayList<>();
    private Logger firstLogger;

    public void addLogger(Logger logger) {
        loggers.add(logger);
        updateChain();
    }

    public void removeLogger(Logger logger) {
        loggers.remove(logger);
        updateChain();
    }

    private void updateChain() {
        firstLogger = null;
        Logger previous = null;
        for (Logger logger : loggers) {
            if (firstLogger == null) {
                firstLogger = logger;
                previous = logger;
            } else {
                previous.setNextLogger(logger);
                previous = logger;
            }
        }
        if (previous != null) {
            previous.setNextLogger(null);
        }
    }

    public void logMessage(int priority, String message) {
        if (firstLogger != null) {
            firstLogger.logMessage(priority, message);
        } else {
            System.out.println("No loggers in chain!");
        }
    }
}