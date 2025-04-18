package eu.telecomnancy.rpg;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.prototype.Team;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;
import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTest {

    @Test
    public void testTeamCloning() {
        Team originalTeam = new Team("Original Team");
        originalTeam.addPlayer(new Warrior("Orube"));
        originalTeam.addPlayer(new Wizard("Tibor"));

        Team clonedTeam = originalTeam.clone();

        assertNotSame(originalTeam, clonedTeam); 
        assertEquals(originalTeam.getName(), clonedTeam.getName()); 
        assertEquals(originalTeam.size(), clonedTeam.size()); 

        
        for (GameCharacter player : originalTeam.getPlayers()) {
            assertTrue(clonedTeam.containsPlayer(player.getName()));
            assertNotSame(player, clonedTeam.getPlayer(player.getName()));
        }
    }
}
