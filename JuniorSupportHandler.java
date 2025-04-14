public class JuniorSupportHandler extends SupportHandler {
    public boolean handle(String issue) {
        if (!issue.contains("billing_issue")|| !issue.contains("refund_request")) {
            System.out.println("[JuniorSupport] Cannot handled "+issue);
            return false;
        }
        System.out.println("[JuniorSupport] Handled: "+issue);
        return next == null || next.handle(issue);
    }
}
