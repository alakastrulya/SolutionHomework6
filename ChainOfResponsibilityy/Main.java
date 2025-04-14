package ChainOfResponsibilityy;

public class Main {
    public static void main(String[] args) {

        LoggerChain loggerChain = new LoggerChain();
        Logger emailLogger = new EmailLogger(Logger.BIG);
        Logger smsLogger = new SMSLogger(Logger.NOTMINI);
        Logger consoleLogger = new LoggerConsole(Logger.MINI);


        loggerChain.addLogger(emailLogger);
        loggerChain.addLogger(smsLogger);
        loggerChain.addLogger(consoleLogger);


        System.out.println("Test logging:");
        loggerChain.logMessage(Logger.MINI, "This is a mini issue.");
        loggerChain.logMessage(Logger.NOTMINI, "This is a little bit more than mini issue.");
        loggerChain.logMessage(Logger.BIG, "We have a big problem!.");


        System.out.println("Remove SMSLogger...");
        loggerChain.removeLogger(smsLogger);
        loggerChain.logMessage(Logger.NOTMINI, "SMSLogger removed, testing again.");


        SupportChain supportChain = new SupportChain();
        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();


        supportChain.addHandler(faq);

        supportChain.addHandler(junior);

        supportChain.addHandler(senior);



        System.out.println("Test support:");
        String[] issues = {"password_reset", "refund_request", "account_ban", "unknown_bug"};
        for (String issue : issues) {
            supportChain.handle(issue);
        }


        System.out.println("Remove Junior...");
        supportChain.removeHandler(junior);
        supportChain.handle("refund_request");
    }
}