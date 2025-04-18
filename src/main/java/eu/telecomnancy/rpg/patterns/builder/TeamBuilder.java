package eu.telecomnancy.rpg.patterns.builder;

import eu.telecomnancy.rpg.patterns.prototype.Team;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

public class TeamBuilder {
    private Team team;

    public TeamBuilder(String name) {
        team = new Team(name);
    }

    public TeamBuilder addWarrior(String name) {
        team.addPlayer(new Warrior(name));
        return this;
    }

    public TeamBuilder addWizard(String name) {
        team.addPlayer(new Wizard(name));
        return this;
    }

    public Team build() {
        return team;
    }
}
