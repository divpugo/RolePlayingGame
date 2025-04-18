package eu.telecomnancy.rpg.patterns.command;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Team;

import java.util.HashMap;
import java.util.Map;

public class AttackCommand implements Command {
    private final Team attackerTeam;
    private final Team defenderTeam;
    private final Map<GameCharacter, Integer> originalHealth;

    public AttackCommand(Team attackerTeam, Team defenderTeam) {
        this.attackerTeam = attackerTeam;
        this.defenderTeam = defenderTeam;
        this.originalHealth = new HashMap<>();
    }

    @Override
    public void execute() {
        System.out.println(attackerTeam.getName() + " attaque " + defenderTeam.getName() + "!");

        for (GameCharacter defender : defenderTeam.getPlayers()) {
            originalHealth.put(defender, defender.getHealth());
        }

        for (GameCharacter attacker : attackerTeam.getPlayers()) {
            for (GameCharacter defender : defenderTeam.getPlayers()) {
                int damage = attacker.attack(50); 
                int takenDamage = defender.defend(damage);
                defender.setHealth(defender.getHealth() - takenDamage);

                System.out.println(attacker.getName() + " envoie " + takenDamage + " degats a " + defender.getName());
            }
        }
    }

    @Override
    public void undo() {
        System.out.println("Undo attaque de " + attackerTeam.getName() + " sur " + defenderTeam.getName());
        
        // Restore health of defenders
        for (GameCharacter defender : defenderTeam.getPlayers()) {
            if (originalHealth.containsKey(defender)) {
                defender.setHealth(originalHealth.get(defender));
            }
        }
    }
}
