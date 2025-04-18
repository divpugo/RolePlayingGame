package eu.telecomnancy.rpg;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.patterns.builder.TeamBuilder;
import eu.telecomnancy.rpg.patterns.prototype.Team;

import static org.junit.jupiter.api.Assertions.*;

public class TeamBuilderTest {
    @Test
    public void testTeamBuilding() {
        TeamBuilder builder = new TeamBuilder("Adventurers");
        Team team = builder.addWarrior("Orube")
                           .addWizard("Tibor")
                           .build();

        assertEquals(2, team.size());
        assertTrue(team.containsPlayer("Orube"));
        assertTrue(team.containsPlayer("Tibor"));
    }
}
