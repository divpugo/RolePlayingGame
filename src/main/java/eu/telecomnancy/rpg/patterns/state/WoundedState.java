package eu.telecomnancy.rpg.patterns.state;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class WoundedState implements State {

    @Override
    public void onEnterState(GameCharacter character) {
        System.out.println(character.getName() + " est blesse et affaibli.");
    }

    @Override
    public void onUpdate(GameCharacter character) {
        System.out.println(character.getName() + " se remet doucement.");
    }

    @Override
    public void onTryToMove(GameCharacter character) {
        System.out.println(character.getName() + " se delace lentement a cause des blessures.");
    }

    @Override
    public void onAttack(GameCharacter character) {
        System.out.println(character.getName() + " attaque avec moins de puissance.");
    }
}
