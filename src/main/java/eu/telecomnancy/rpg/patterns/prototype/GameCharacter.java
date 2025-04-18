package eu.telecomnancy.rpg.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.rpg.patterns.observer.Observer;
import eu.telecomnancy.rpg.patterns.strategy.CombatStrategy;
import eu.telecomnancy.rpg.patterns.strategy.NeutralStrategy;
import eu.telecomnancy.rpg.patterns.visitor.CharacterVisitor;
import eu.telecomnancy.rpg.patterns.state.NormalState;
import eu.telecomnancy.rpg.patterns.state.State;

public abstract class GameCharacter implements Cloneable {

    private final String name;
    private int health;
    private int experiencePoints;
    private int level;
    private CombatStrategy combatStrategy;
    private State currentState;

    // List pour gerer les observers
    private final List<Observer> observers;

    public abstract void accept(CharacterVisitor visitor);

    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.level = 1;
        this.health = 100;
        this.currentState = new NormalState();
        this.combatStrategy = new NeutralStrategy();
        this.observers = new ArrayList<>(); 
    }

    // Gestion des differents states
    public void setState(State newState) {
        this.currentState = newState; 
        newState.onEnterState(this);  
    }
    
    public State getState() {
        return currentState;
    }
    public void update() {
        currentState.onUpdate(this); 
    }

    public void tryToMove() {
        currentState.onTryToMove(this); 
    }

    public void attack() {
        currentState.onAttack(this); 
    }

    // Gestion des observers
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(this, event);
        }
    }

    // Configurations de depart
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health <= 0) {
            notifyObservers("Death"); 
        }
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp() {
        this.level++;
        notifyObservers("LevelUp"); 
    }

    @Override
    public String toString() {
        return name + " (Level " + level + ") with " + health + " HP and " + experiencePoints + " XP";
    }

    public void setCombatStrategy(CombatStrategy strategy) {
        this.combatStrategy = strategy;
    }

    public int attack(int baseDamage) {
        return combatStrategy.calculateDamageDealt(baseDamage);
    }

    public int defend(int baseDamage) {
        return combatStrategy.calculateDamageTaken(baseDamage);
    }

    @Override
    public GameCharacter clone() {
        try {
            return (GameCharacter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }
}
