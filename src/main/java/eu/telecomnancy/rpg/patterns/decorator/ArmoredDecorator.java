package eu.telecomnancy.rpg.patterns.decorator;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class ArmoredDecorator extends CharacterDecorator {
    private final int armorValue;

    public ArmoredDecorator(GameCharacter character, int armorValue) {
        super(character);
        this.armorValue = armorValue;
    }

    @Override
    public int defend(int baseDamage) {
        int reducedDamage = Math.max(0, baseDamage - armorValue);
        return super.defend(reducedDamage);
    }
}
