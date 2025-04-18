package eu.telecomnancy.rpg.patterns.prototype;

import java.util.Random;

import eu.telecomnancy.rpg.patterns.visitor.CharacterVisitor;

public class Warrior extends GameCharacter {
    private int strength;

    public Warrior(String name) {
        super(name);
        strength = getLevel() * 10+new Random().nextInt(10);
    }

    public int getStrength() {
        return strength;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void accept(CharacterVisitor visitor){
        visitor.visit(this);
    }
        
    @Override
    public Warrior clone() {
        return (Warrior) super.clone();
    }
}
