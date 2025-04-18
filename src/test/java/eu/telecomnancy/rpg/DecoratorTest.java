package eu.telecomnancy.rpg;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.decorator.ArmoredDecorator;
import eu.telecomnancy.rpg.patterns.decorator.InvincibleDecorator;
import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    public void testArmoredDecorator() {
        GameCharacter warrior = new Warrior("TestWarrior");
        warrior.setHealth(100);

        warrior = new ArmoredDecorator(warrior, 20);
        int damage = warrior.defend(50); // Armor reduit par 20
        warrior.setHealth(warrior.getHealth() - damage);
        assertEquals(70, warrior.getHealth()); // 100 - 30 = 70
    }

    @Test
    public void testInvincibleDecorator() {
        GameCharacter wizard = new Wizard("TestWizard");
        wizard.setHealth(100);

        wizard = new InvincibleDecorator(wizard);
        wizard.setHealth(0);
        assertEquals(1, wizard.getHealth()); // Sante devrait pas etre inferieure a 1
    }

    @Test
    public void testCombinedDecorators() {
        GameCharacter warrior = new Warrior("TestWarrior");
        warrior.setHealth(100);

        warrior = new ArmoredDecorator(warrior, 30);
        warrior = new InvincibleDecorator(warrior);

        int damage = warrior.defend(40); // 40 - 30 = 10
        warrior.setHealth(warrior.getHealth() - damage);
        assertEquals(90, warrior.getHealth()); // 100 - 10 = 90

        warrior.setHealth(0);
        assertEquals(1, warrior.getHealth()); // Invincibilite assure que sante reste a 1
    }
}
