package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.prototype.Team;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;
import eu.telecomnancy.rpg.patterns.prototype.GameCharacter;

class TeamTest {

    @Test
    void testCreateTeam() {
        Team team = new Team("test");
        assertEquals(0, team.size());
        

    }

    @Test void AddCharacterToTeam() {
        Team team = new Team("test");
        Wizard character = new Wizard("test");
        team.addPlayer(character);
        assertEquals(1, team.size());
    }

    @Test
    public void testClone() {
        Team originalTeam = new Team("Original Team");
        GameCharacter warrior = new Warrior("Warrior");
        GameCharacter wizard = new Wizard("Wizard");

        originalTeam.addPlayer(warrior);
        originalTeam.addPlayer(wizard);

        Team clonedTeam = originalTeam.clone();

        assertNotSame(originalTeam, clonedTeam); 
        assertEquals(originalTeam.getName(), clonedTeam.getName()); 
        assertEquals(originalTeam.size(), clonedTeam.size()); 

        
        for (GameCharacter player : originalTeam.getPlayers()) {
            GameCharacter clonedPlayer = clonedTeam.getPlayer(player.getName());
            assertNotSame(player, clonedPlayer);
            assertEquals(player.getName(), clonedPlayer.getName());
        }
    }
}