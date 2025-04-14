package ChainOfResponsibilityy;

public class SMSLogger extends Logger {

    public SMSLogger(int priority) {
        this.priority = priority;
    }

    @Override
    protected void write(String message) {
        System.out.println("SMS Logger: " + message);
    }

}
