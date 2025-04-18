package eu.telecomnancy.rpg.patterns.strategy;

public class DefensiveStrategy implements CombatStrategy {
    @Override
    public int calculateDamageDealt(int baseDamage) {
        return (int) (baseDamage * 0.75); // 25% less damage dealt
    }

    @Override
    public int calculateDamageTaken(int baseDamage) {
        return (int) (baseDamage * 0.75); // 25% less damage taken
    }
}
