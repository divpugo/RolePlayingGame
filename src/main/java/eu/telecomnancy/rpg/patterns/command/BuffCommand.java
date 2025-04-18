package eu.telecomnancy.rpg.patterns.command;

import eu.telecomnancy.rpg.patterns.prototype.Team;
import eu.telecomnancy.rpg.patterns.visitor.BuffVisitor;

public class BuffCommand implements Command {
    private final Team team;

    public BuffCommand(Team team) {
        this.team = team;
    }

    @Override
    public void execute() {
        BuffVisitor buffVisitor = new BuffVisitor();
        for (var character : team.getPlayers()) {
            character.accept(buffVisitor);
        }
        System.out.println("Equipe " + team.getName() + " amelioree.");
    }

    @Override
    public void undo() {
        System.out.println("Undo buffing pas implemente.");
    }
}
