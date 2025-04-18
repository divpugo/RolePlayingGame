package eu.telecomnancy.rpg;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.observer.DeathObserver;
import eu.telecomnancy.rpg.patterns.observer.LevelUpObserver;
import eu.telecomnancy.rpg.patterns.observer.Subject;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @Test
    public void testObservers() {

        Subject subject = new Subject();


        LevelUpObserver levelUpObserver = new LevelUpObserver();
        DeathObserver deathObserver = new DeathObserver();


        GameCharacter warrior = new Warrior("ObserverWarrior");


        subject.addObserver(levelUpObserver);
        subject.addObserver(deathObserver);


        warrior.setLevel(2);
        subject.notifyObservers(warrior, "LevelUp");
        assertEquals(2, warrior.getLevel(), "Mise a jour du niveau du Warrior et LevelUpObserver est notifie.");

 
        warrior.setHealth(0);
        subject.notifyObservers(warrior, "Death");
        assertEquals(0, warrior.getHealth(), "Sante du Warrior est 0 et DeathObserver est notifier.");


        subject.removeObserver(levelUpObserver);
        subject.removeObserver(deathObserver);

        warrior.setLevel(3);
        subject.notifyObservers(warrior, "LevelUp");
        assertEquals(3, warrior.getLevel(), "Pas de notification apres enlevements des observers.");
    }
}
