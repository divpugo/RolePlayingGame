package eu.telecomnancy.rpg.patterns.decorator;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.visitor.CharacterVisitor;

public abstract class CharacterDecorator extends GameCharacter {
    protected GameCharacter decoratedCharacter;

    public CharacterDecorator(GameCharacter character) {
        super(character.getName());
        this.decoratedCharacter = character;
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        decoratedCharacter.accept(visitor);
    }

    @Override
    public int attack(int baseDamage) {
        return decoratedCharacter.attack(baseDamage);
    }

    @Override
    public int defend(int baseDamage) {
        return decoratedCharacter.defend(baseDamage);
    }

    @Override
    public void setHealth(int health) {
        decoratedCharacter.setHealth(health);
    }

    @Override
    public int getHealth() {
        return decoratedCharacter.getHealth();
    }

    @Override
    public int getExperiencePoints() {
        return decoratedCharacter.getExperiencePoints();
    }

    @Override
    public void setExperiencePoints(int experiencePoints) {
        decoratedCharacter.setExperiencePoints(experiencePoints);
    }

    @Override
    public int getLevel() {
        return decoratedCharacter.getLevel();
    }

    @Override
    public void setLevel(int level) {
        decoratedCharacter.setLevel(level);
    }

    public GameCharacter getDecoratedCharacter() {
        return decoratedCharacter;
    }
}
