package eu.telecomnancy.rpg.patterns.strategy;

public class NeutralStrategy implements CombatStrategy {
    @Override
    public int calculateDamageDealt(int baseDamage) {
        return baseDamage; // Standard damage
    }

    @Override
    public int calculateDamageTaken(int baseDamage) {
        return baseDamage; // Standard damage
    }
}
