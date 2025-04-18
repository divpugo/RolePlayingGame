package eu.telecomnancy.rpg.patterns.strategy;

public class AggressiveStrategy implements CombatStrategy {
    @Override
    public int calculateDamageDealt(int baseDamage) {
        return (int) (baseDamage * 1.5); // 50% more damage
    }

    @Override
    public int calculateDamageTaken(int baseDamage) {
        return (int) (baseDamage * 1.5); // 50% more damage taken
    }
}
