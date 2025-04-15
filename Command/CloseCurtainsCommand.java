package Command;

public class CloseCurtainsCommand implements Command {
    private Curtains curtains;

    public CloseCurtainsCommand(Curtains curtains) {
        this.curtains = curtains;
    }

    public void execute() {
        curtains.close();
    }

    public void undo() {
        curtains.open();
    }
}