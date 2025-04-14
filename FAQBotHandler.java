public class FAQBotHandler extends SupportHandler{
    public boolean handle(String issue) {
        if (!issue.contains("password_reset")) {
            System.out.println("[FAQBot] Cannot handled "+issue);
            return false;
        }
        System.out.println("[FAQBot] Handled: "+issue+" escalate manually");
        return next == null || next.handle(issue);
    }
}
