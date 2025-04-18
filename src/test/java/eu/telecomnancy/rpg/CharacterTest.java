package eu.telecomnancy.rpg;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    @Test
    public void testCreateCharacter() {
        
        GameCharacter warrior = new Warrior("TestWarrior");

        assertEquals(100, warrior.getHealth(), "Nouveau warrior debute avec 100 points de sante.");

        assertEquals(0, warrior.getExperiencePoints(), "Nouveau warrior debute avec 0 points d'experience.");
    }
}
