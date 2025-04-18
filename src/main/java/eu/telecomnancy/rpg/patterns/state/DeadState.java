package eu.telecomnancy.rpg.patterns.state;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class DeadState implements State {

    @Override
    public void onEnterState(GameCharacter character) {
        System.out.println(character.getName() + " est mort!");
    }

    @Override
    public void onUpdate(GameCharacter character) {
        System.out.println(character.getName() + " peut rien faire ; il est mort.");
    }

    @Override
    public void onTryToMove(GameCharacter character) {
        throw new IllegalStateException(character.getName() + " peut pas se deplacer ; il est mort.");
    }

    @Override
    public void onAttack(GameCharacter character) {
        throw new IllegalStateException(character.getName() + " peut pas attaquer ; il est mort.");
    }
}
