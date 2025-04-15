package Command;

import java.util.List;

public class MiniCommand implements Command {
    private List<Command> commands;

    public MiniCommand(List<Command> commands) {
        this.commands = commands;
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}