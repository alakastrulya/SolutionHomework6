package Command;

public class Curtains {
    private boolean isOpen;

    public Curtains() {
        this.isOpen = true;
    }

    public void open() {
        this.isOpen = true;
        System.out.println("[Curtains] Opening curtains");
    }

    public void close() {
        this.isOpen = false;
        System.out.println("[Curtains] Closing curtains");
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getStatus() {
        return isOpen ? "open" : "close";
    }
}