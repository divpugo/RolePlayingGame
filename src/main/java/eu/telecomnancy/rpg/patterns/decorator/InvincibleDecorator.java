package eu.telecomnancy.rpg.patterns.decorator;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class InvincibleDecorator extends CharacterDecorator {

    public InvincibleDecorator(GameCharacter character) {
        super(character);
    }

    @Override
    public void setHealth(int health) {
        if (health < 1) {
            super.setHealth(1);
        } else {
            super.setHealth(health);
        }
    }
}
