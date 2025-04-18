package eu.telecomnancy.rpg.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class GameInvoker {
    private final List<Command> commandHistory = new ArrayList<>();

    public void addCommand(Command command) {
        commandHistory.add(command);
    }

    public void executeCommands() {
        for (Command command : commandHistory) {
            command.execute();
        }
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
        } else {
            System.out.println("Pas de commands a undo.");
        }
    }
}
