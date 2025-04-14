package ChainOfResponsibilityy;

public abstract class SupportHandler {
    protected SupportHandler next;
    public SupportHandler set_next(SupportHandler handler){
            this.next = handler;
            return next;
    }
    abstract boolean handle(String issue);
}
