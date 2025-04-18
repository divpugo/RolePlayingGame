package eu.telecomnancy.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.visitor.BuffVisitor;
import eu.telecomnancy.rpg.patterns.visitor.DamageVisitor;
import eu.telecomnancy.rpg.patterns.visitor.HealVisitor;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

    private Warrior warrior;
    private Wizard wizard;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Orube");
        warrior.setHealth(50);
        warrior.setStrength(30);

        wizard = new Wizard("Tibor");
        wizard.setHealth(40);
        wizard.setIntelligence(50);
    }

    @Test
    void testBuffVisitor() {
        BuffVisitor buffVisitor = new BuffVisitor();
        warrior.accept(buffVisitor);
        wizard.accept(buffVisitor);

        assertEquals(40, warrior.getStrength(), "Force de Warrior devrait augmenter de 10");
        assertEquals(65, wizard.getIntelligence(), "Intelligence de Wizard devrait augmenter de 15");
    }

    @Test
    void testDamageVisitor() {
        DamageVisitor damageVisitor = new DamageVisitor();
        warrior.accept(damageVisitor);
        wizard.accept(damageVisitor);

        assertEquals(30, warrior.getHealth(), "Sante de Warrior devrait diminuer de 20");
        assertEquals(25, wizard.getHealth(), "Sante de Wizard devrait diminuer de 15");
    }

    @Test
    void testHealVisitor() {
        HealVisitor healVisitor = new HealVisitor();
        warrior.setHealth(50); 
        wizard.setHealth(40); 

        warrior.accept(healVisitor);
        wizard.accept(healVisitor);

        assertEquals(75, warrior.getHealth(), "Sante de warrior devrait augmenter de 25");
        assertEquals(60, wizard.getHealth(), "Sante de wizard devrait augmenter de 20");
    }

    @Test
    void testCombinedVisitors() {
        BuffVisitor buffVisitor = new BuffVisitor();
        DamageVisitor damageVisitor = new DamageVisitor();
        HealVisitor healVisitor = new HealVisitor();

        warrior.setHealth(50); 
        warrior.accept(buffVisitor);
        warrior.accept(damageVisitor);
        warrior.accept(healVisitor);

        wizard.setHealth(40); 
        wizard.accept(buffVisitor);
        wizard.accept(damageVisitor);
        wizard.accept(healVisitor);

        assertEquals(40, warrior.getStrength(), "Force de Warrior apres buff devrait etre 40");
        assertEquals(65, wizard.getIntelligence(), "Intelligence de Wizard apres buff devrait etre 65");
        assertEquals(55, warrior.getHealth(), "Sante de Warrior apres damage et heal devrait etre 55");
        assertEquals(45, wizard.getHealth(), "Sante de Wizard apres damage et heal devrait etre 45");
    }
}
