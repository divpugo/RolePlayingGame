package eu.telecomnancy.rpg;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.singleton.GameConfiguration;

import static org.junit.jupiter.api.Assertions.*;

public class GameConfigurationTest {
    @Test
    public void testSingletonInstance() {
        GameConfiguration config1 = GameConfiguration.getInstance();
        GameConfiguration config2 = GameConfiguration.getInstance();
        assertSame(config1, config2); 
    }

    @Test
    public void testGlobalParameters() {
        GameConfiguration config = GameConfiguration.getInstance();
        config.setDifficultyLevel(3);
        config.setMaxTeamSize(6);
        assertEquals(3, config.getDifficultyLevel());
        assertEquals(6, config.getMaxTeamSize());
    }
}
