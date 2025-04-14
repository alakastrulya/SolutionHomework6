package ChainOfResponsibilityy;

import java.util.ArrayList;
import java.util.List;

public class SupportChain {
    private List<SupportHandler> handlers = new ArrayList<>();
    private SupportHandler firstHandler;

    public void addHandler(SupportHandler handler) {
        handlers.add(handler);
        updateChain();
    }

    public void removeHandler(SupportHandler handler) {
        handlers.remove(handler);
        updateChain();
    }

    private void updateChain() {
        firstHandler = null;
        SupportHandler previous = null;
        for (SupportHandler handler : handlers) {
            if (firstHandler == null) {
                firstHandler = handler;
                previous = handler;
            } else {
                previous.set_next(handler);
                previous = handler;
            }
        }
        if (previous != null) {
            previous.set_next(null);
        }
    }

    public boolean handle(String issue) {
        return firstHandler != null && firstHandler.handle(issue);
    }
}