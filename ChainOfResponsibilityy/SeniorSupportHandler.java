package ChainOfResponsibilityy;

public class SeniorSupportHandler extends SupportHandler {
    public boolean handle(String issue) {
        if (issue.contains("account_ban") || issue.contains("data_loss")) {
            System.out.println("[SeniorSupport] Handled: "+issue);
            return next == null || next.handle(issue);
        }
        System.out.println("[SeniorSupport] Cannot handled "+issue+" escalate manually");
        return next != null && next.handle(issue);
    }
}