package eu.telecomnancy.rpg.patterns.observer;

import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(GameCharacter character, String event) {
        for (Observer observer : observers) {
            observer.update(character, event);
        }
    }
}
