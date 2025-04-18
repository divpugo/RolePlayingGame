package eu.telecomnancy.rpg;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.state.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    @Test
    public void testStateTransitions() {
        GameCharacter warrior = new Warrior("TestWarrior");

        assertTrue(warrior.getState() instanceof NormalState, "Warrior devrait etre dans l'etat NormalState");

        warrior.setState(new WoundedState());
        assertTrue(warrior.getState() instanceof WoundedState, "Warrior devrait changer d'etat a WoundedState");

        warrior.setState(new ScaredState());
        assertTrue(warrior.getState() instanceof ScaredState, "Warrior changer d'etat a ScaredState");

        warrior.setState(new DeadState());
        assertTrue(warrior.getState() instanceof DeadState, "Warrior changer d'etat a DeadState");
    }

    @Test
    public void testDeadStateBehavior() {
        GameCharacter warrior = new Warrior("TestWarrior");

        warrior.setState(new DeadState());

        assertTrue(warrior.getState() instanceof DeadState, "Warrior devrait etre dans l'etat DeadState");

        assertThrows(IllegalStateException.class, warrior::tryToMove, "Warrior mort ne devrait pas pouvoir se deplacer.");
        assertThrows(IllegalStateException.class, warrior::attack, "Warrior mort ne devrait pas pouvoir attaquer.");
    }

    @Test
    public void testStateConsistency() {
        GameCharacter warrior = new Warrior("TestWarrior");

        assertTrue(warrior.getState() instanceof NormalState, "Warrior devrait debuter dans l'etat NormalState");

        warrior.setState(new WoundedState());
        assertTrue(warrior.getState() instanceof WoundedState, "Warrior devrait changer d'etat a WoundedState");

        warrior.setState(new ScaredState());
        assertTrue(warrior.getState() instanceof ScaredState, "Warrior devrait changer d'etat a ScaredState");

        warrior.setState(new DeadState());
        assertTrue(warrior.getState() instanceof DeadState, "Warrior devrait changer d'etat a DeadState");
    }
}
