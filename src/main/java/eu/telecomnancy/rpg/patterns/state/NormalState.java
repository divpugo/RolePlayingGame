package eu.telecomnancy.rpg.patterns.state;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class NormalState implements State {

    @Override
    public void onEnterState(GameCharacter character) {
        System.out.println(character.getName() + " est dans l'etat normal.");
    }

    @Override
    public void onUpdate(GameCharacter character) {
        System.out.println(character.getName() + " est pret a combattre.");
    }

    @Override
    public void onTryToMove(GameCharacter character) {
        System.out.println(character.getName() + " peut se deplacer.");
    }

    @Override
    public void onAttack(GameCharacter character) {
        System.out.println(character.getName() + " peut attaquer a pleine puissance.");
    }
}
