package eu.telecomnancy.rpg.patterns.observer;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class LevelUpObserver implements Observer {
    @Override
    public void update(GameCharacter character, String event) {
        if (event.equals("LevelUp")) {
            System.out.println(character.getName() + " leveled up to level " + character.getLevel() + "!");
        }
    }
}
