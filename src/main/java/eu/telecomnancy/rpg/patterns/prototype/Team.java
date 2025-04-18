package eu.telecomnancy.rpg.patterns.prototype;

import java.util.ArrayList;
import java.util.Collection;

public class Team implements Cloneable {

    private final String name;
    private Collection<GameCharacter> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Collection<GameCharacter> getPlayers() {
        return players;
    }

    public void addPlayer(GameCharacter player) {
        players.add(player);
    }

    public void removePlayer(GameCharacter player) {
        players.remove(player);
    }

    public void removePlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                return;
            }
        }
    }

    public GameCharacter getPlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public boolean containsPlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsPlayer(GameCharacter player) {
        return players.contains(player);
    }

    public int size() {
        return players.size();
    }

    @Override
    public Team clone() {
        try {
            Team clonedTeam = (Team) super.clone();
            // Create a deep copy of the players collection
            clonedTeam.players = new ArrayList<>();
            for (GameCharacter player : this.players) {
                clonedTeam.players.add(player.clone());
            }
            return clonedTeam;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }
}
