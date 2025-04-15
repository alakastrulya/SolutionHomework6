package Command;

public class OpenCurtainsCommand implements Command {
    private Curtains curtains;

    public OpenCurtainsCommand(Curtains curtains) {
        this.curtains = curtains;
    }

    public void execute() {
        curtains.open();
    }

    public void undo() {
        curtains.close();
    }
}