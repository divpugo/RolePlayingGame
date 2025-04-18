package eu.telecomnancy.rpg.patterns.command;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Team;

import java.util.HashMap;
import java.util.Map;

public class HealCommand implements Command {
    private final Team team;
    private final Map<GameCharacter, Integer> originalHealth = new HashMap<>();

    public HealCommand(Team team) {
        this.team = team;
    }

    @Override
    public void execute() {
        for (GameCharacter character : team.getPlayers()) {
            originalHealth.put(character, character.getHealth());
            character.setHealth(100); 
        }
        System.out.println("Equipe " + team.getName() + " guerie.");
    }

    @Override
    public void undo() {
        for (GameCharacter character : team.getPlayers()) {
            if (originalHealth.containsKey(character)) {
                character.setHealth(originalHealth.get(character)); 
            }
        }
        System.out.println("Undo guerison de " + team.getName());
    }
}
