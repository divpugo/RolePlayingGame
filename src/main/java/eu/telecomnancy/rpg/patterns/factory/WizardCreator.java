package eu.telecomnancy.rpg.patterns.factory;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

public class WizardCreator implements CharacterCreator {
    @Override
    public GameCharacter createCharacter(String name) {
        return new Wizard(name);
    }
}
