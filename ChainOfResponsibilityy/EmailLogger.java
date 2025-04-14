package ChainOfResponsibilityy;

public class EmailLogger extends Logger {
        public EmailLogger(int priority) {
            this.priority = priority;
        }

        @Override
        protected void write(String message) {
            System.out.println("Email Logger: " + message);
        }

}
