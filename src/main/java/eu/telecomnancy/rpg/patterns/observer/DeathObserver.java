package eu.telecomnancy.rpg.patterns.observer;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class DeathObserver implements Observer {
    @Override
    public void update(GameCharacter character, String event) {
        if (event.equals("Death")) {
            System.out.println(character.getName() + " has died!");
        }
    }
}
