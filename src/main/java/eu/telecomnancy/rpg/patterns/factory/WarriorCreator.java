package eu.telecomnancy.rpg.patterns.factory;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;

public class WarriorCreator implements CharacterCreator {
    @Override
    public GameCharacter createCharacter(String name) {
        return new Warrior(name);
    }
}
