package eu.telecomnancy.rpg.patterns.state;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

public class ScaredState implements State {

    @Override
    public void onEnterState(GameCharacter character) {
        System.out.println(character.getName() + " a peur !");
    }

    @Override
    public void onUpdate(GameCharacter character) {
        System.out.println(character.getName() + " hesite par peur.");
    }

    @Override
    public void onTryToMove(GameCharacter character) {
        System.out.println(character.getName() + " se deplace frenetiquement parce qu'il a peur.");
    }

    @Override
    public void onAttack(GameCharacter character) {
        System.out.println(character.getName() + " attaque precautioneusement.");
    }
}
