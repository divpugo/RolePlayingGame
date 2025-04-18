package eu.telecomnancy.rpg.patterns.prototype;

import java.util.Random;

import eu.telecomnancy.rpg.patterns.visitor.CharacterVisitor;


public class Wizard extends GameCharacter {

    private int intelligence;

    public Wizard(String name) {
        super(name);
        intelligence = getLevel() * 10+new Random().nextInt(10);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    @Override
    public void accept(CharacterVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public Wizard clone() {
        return (Wizard) super.clone();
    }
    
}
