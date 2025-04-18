package eu.telecomnancy.rpg.patterns.singleton;

public class GameConfiguration {
    private static GameConfiguration instance;

    private int difficultyLevel;
    private int maxTeamSize;

    private GameConfiguration() {
        this.difficultyLevel = 1; 
        this.maxTeamSize = 4; 
    }

    public static GameConfiguration getInstance() {
        if (instance == null) {
            instance = new GameConfiguration();
        }
        return instance;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(int maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }
}
