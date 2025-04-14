package ChainOfResponsibilityy;

public class LoggerConsole extends Logger {
    public LoggerConsole(int priority) {
        this.priority = priority;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console Logger: " + message);
    }
}
