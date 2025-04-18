package eu.telecomnancy.rpg.patterns.command;

public interface Command {
    void execute();
    void undo();
}
