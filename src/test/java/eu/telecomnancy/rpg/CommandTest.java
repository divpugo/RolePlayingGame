package eu.telecomnancy.rpg;

import eu.telecomnancy.rpg.facade.GameFacade;
import eu.telecomnancy.rpg.patterns.command.*;
import eu.telecomnancy.rpg.patterns.prototype.Team;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    public void testCommandExecution() {
        GameFacade facade = new GameFacade();

        // Create Teams
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");
        Warrior warrior1 = new Warrior("Warrior1");
        warrior1.setHealth(25);
        Wizard wizard1 = new Wizard("Wizard1");
        wizard1.setHealth(20);

        team1.addPlayer(warrior1);
        team2.addPlayer(wizard1);

        facade.addTeam(team1);
        facade.addTeam(team2);

        HealCommand healCommand = new HealCommand(team1);
        healCommand.execute();

        for (var character : team1.getPlayers()) {
            assertEquals(100, character.getHealth(), character.getName() + " devrait etre gueri au max health.");
        }
    }

    @Test
    public void testUndoCommand() {
        GameFacade facade = new GameFacade();

        Team team1 = new Team("Team1");
        Warrior warrior1 = new Warrior("Warrior1");
        warrior1.setHealth(25);

        team1.addPlayer(warrior1);

        facade.addTeam(team1);

        HealCommand healCommand = new HealCommand(team1);
        healCommand.execute();

        healCommand.undo();

        for (var character : team1.getPlayers()) {
            assertEquals(25, character.getHealth(), character.getName() + " devrait revenir au niveau de sante precedente.");
        }
    }

    @Test
    public void testAttackCommandExecutionAndUndo() {
        GameFacade facade = new GameFacade();

        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Warrior warrior1 = new Warrior("Warrior1");
        warrior1.setHealth(100);
        Wizard wizard1 = new Wizard("Wizard1");
        wizard1.setHealth(100);

        team1.addPlayer(warrior1);
        team2.addPlayer(wizard1);

        facade.addTeam(team1);
        facade.addTeam(team2);

        AttackCommand attackCommand = new AttackCommand(team1, team2);
        attackCommand.execute();

        for (var character : team2.getPlayers()) {
            assertTrue(character.getHealth() < 100, character.getName() + " devrait recevoir des degats.");
        }

        attackCommand.undo();

        for (var character : team2.getPlayers()) {
            assertEquals(100, character.getHealth(), character.getName() + "devrait avoir sa sante initiale.");
        }
    }
}
