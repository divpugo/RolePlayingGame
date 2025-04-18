package eu.telecomnancy.rpg;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;
import eu.telecomnancy.rpg.patterns.factory.CharacterCreator;
import eu.telecomnancy.rpg.patterns.factory.WarriorCreator;
import eu.telecomnancy.rpg.patterns.factory.WizardCreator;
import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterCreatorTest {
    @Test
    public void testWarriorCreation() {
        CharacterCreator creator = new WarriorCreator();
        GameCharacter warrior = creator.createCharacter("Orube");
        assertTrue(warrior instanceof Warrior);
        assertEquals("Orube", warrior.getName());
    }

    @Test
    public void testWizardCreation() {
        CharacterCreator creator = new WizardCreator();
        GameCharacter wizard = creator.createCharacter("Tibor");
        assertTrue(wizard instanceof Wizard);
        assertEquals("Tibor", wizard.getName());
    }
}
