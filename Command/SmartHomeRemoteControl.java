package Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SmartHomeRemoteControl {
    private Map<Integer, Command> slots;
    private Stack<Command> undoHistory;
    private Stack<Command> redoHistory;

    public SmartHomeRemoteControl() {
        this.slots = new HashMap<>();
        this.undoHistory = new Stack<>();
        this.redoHistory = new Stack<>();
    }

    public void setCommand(int slot, Command command) {
        slots.put(slot, command);
    }

    public void pressButton(int slot) {
        Command command = slots.get(slot);
        if (command != null) {
            command.execute();
            undoHistory.push(command);
            redoHistory.clear();
        } else {
            System.out.println("In slots we dont have " + slot + " command");
        }
    }

    public void undoButton() {
        if (!undoHistory.isEmpty()) {
            Command command = undoHistory.pop();
            command.undo();
            redoHistory.push(command);
        } else {
            System.out.println("nothing to undo");
        }
    }

    public void redoButton() {
        if (!redoHistory.isEmpty()) {
            Command command = redoHistory.pop();
            command.execute();
            undoHistory.push(command);
        } else {
            System.out.println("nothing to redo");
        }
    }
}