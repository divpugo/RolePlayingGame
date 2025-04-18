package eu.telecomnancy.rpg.patterns.factory;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public interface CharacterCreator {
    GameCharacter createCharacter(String name);
}
