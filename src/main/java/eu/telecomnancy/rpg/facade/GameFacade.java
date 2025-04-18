package eu.telecomnancy.rpg.facade;

import eu.telecomnancy.rpg.patterns.decorator.CharacterDecorator;
import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Team;
import eu.telecomnancy.rpg.patterns.visitor.BuffVisitor;
import eu.telecomnancy.rpg.patterns.visitor.HealVisitor;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class GameFacade {
    private final List<Team> teams;

    public GameFacade() {
        this.teams = new ArrayList<>();
    }

    // Ajout d'une equipe
    public void addTeam(Team team) {
        teams.add(team);
        System.out.println("Equipe " + team.getName() + " ajoutee.");
    }

    // Suppression d'une equipe
    public void removeTeam(Team team) {
        teams.remove(team);
        System.out.println("Equipe " + team.getName() + " enelvee.");
    }

    // Retrouver une equipe par nom
    public Team getTeam(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        System.out.println("Equipe " + name + " pas trouvee.");
        return null;
    }

    // La liste de toutes les equipes
    public List<Team> getAllTeams() {
        return new ArrayList<>(teams);
    }

    // Attaque une equipe
    public void teamAttack(Team attacker, Team defender) {
        System.out.println(attacker.getName() + " attaque " + defender.getName() + "!");
        for (GameCharacter attackerChar : attacker.getPlayers()) {
            for (GameCharacter defenderChar : defender.getPlayers()) {
                int damage = attackerChar.attack(50); 
                int taken = defenderChar.defend(damage);
                defenderChar.setHealth(defenderChar.getHealth() - taken);
                System.out.println(attackerChar.getName() + " envoie " + taken + " degats a " + defenderChar.getName());
            }
        }
    }

    // Gueri une equipe
    public void healTeam(Team team) {
        System.out.println("Equipe guerie : " + team.getName());
        HealVisitor healVisitor = new HealVisitor();
        for (GameCharacter character : team.getPlayers()) {
            character.accept(healVisitor);
        }
    }

    // Ameliore une equipe
    public void buffTeam(Team team) {
        System.out.println("Equipe amelioree : " + team.getName());
        BuffVisitor buffVisitor = new BuffVisitor();
        for (GameCharacter character : team.getPlayers()) {
            character.accept(buffVisitor);
        }
    }

    // Ajoute un decorator a un personnage
    public GameCharacter decorateCharacter(GameCharacter character, Class<? extends CharacterDecorator> decoratorClass) {
        try {
            Constructor<? extends CharacterDecorator> constructor = decoratorClass.getConstructor(GameCharacter.class);
            GameCharacter decoratedCharacter = constructor.newInstance(character);
            System.out.println(character.getName() + " est maintenant decore avec " + decoratorClass.getSimpleName());
            return decoratedCharacter; 
        } catch (Exception e) {
            System.err.println("Incapable de decorer le personnage : " + e.getMessage());
            return character; 
        }
    }

    // Supprime le decorator d'un personnage
    public void removeDecorator(GameCharacter character) {
        if (character instanceof CharacterDecorator) {
            CharacterDecorator decorator = (CharacterDecorator) character;
            GameCharacter original = decorator.getDecoratedCharacter();
            System.out.println("Decorator supprime pour " + original.getName());
        } else {
            System.out.println(character.getName() + " n'a pas de decorator.");
        }
    }

    // Renvoie une liste des equipes
    public void listTeams() {
        System.out.println("Equipes :");
        for (Team team : teams) {
            System.out.println("- " + team.getName());
        }
    }
}
