package ChainOfResponsibilityy;

public abstract class Logger {
    public static int MINI = 1;
    public static int NOTMINI = 2;
    public static int BIG = 3;

    protected int priority;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int priority, String message) {
        if (this.priority <= priority) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(priority, message);
        }
    }

    protected abstract void write(String message);
}
