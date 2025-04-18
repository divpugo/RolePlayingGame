package eu.telecomnancy.rpg;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.strategy.AggressiveStrategy;
import eu.telecomnancy.rpg.patterns.strategy.DefensiveStrategy;
import eu.telecomnancy.rpg.patterns.strategy.NeutralStrategy;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {
    @Test
    public void testCombatStrategies() {
        GameCharacter warrior = new Warrior("TestWarrior");

        // Aggressive strategy
        warrior.setCombatStrategy(new AggressiveStrategy());
        assertEquals(150, warrior.attack(100));
        assertEquals(150, warrior.defend(100));

        // Defensive strategy
        warrior.setCombatStrategy(new DefensiveStrategy());
        assertEquals(75, warrior.attack(100));
        assertEquals(75, warrior.defend(100));

        // Neutral strategy
        warrior.setCombatStrategy(new NeutralStrategy());
        assertEquals(100, warrior.attack(100));
        assertEquals(100, warrior.defend(100));
    }
}
