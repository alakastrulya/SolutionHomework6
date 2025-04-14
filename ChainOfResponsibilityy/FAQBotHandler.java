package ChainOfResponsibilityy;

public class FAQBotHandler extends SupportHandler {
    public boolean handle(String issue) {
        if (issue.contains("password_reset")) {
            System.out.println("[FAQBot] Handled: "+issue);
            return next == null || next.handle(issue);
        }
        System.out.println("[FAQBot] Cannot handled "+issue);
        return next != null && next.handle(issue);
    }
}
