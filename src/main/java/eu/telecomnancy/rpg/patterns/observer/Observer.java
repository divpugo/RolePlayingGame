package eu.telecomnancy.rpg.patterns.observer;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public interface Observer {
    void update(GameCharacter character, String event);
}
