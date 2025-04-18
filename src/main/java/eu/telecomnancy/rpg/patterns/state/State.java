package eu.telecomnancy.rpg.patterns.state;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public interface State {
    void onEnterState(GameCharacter character); 
    void onUpdate(GameCharacter character);    
    void onTryToMove(GameCharacter character); 
    void onAttack(GameCharacter character);    
}
