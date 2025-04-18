package eu.telecomnancy.rpg.patterns.strategy;

public interface CombatStrategy {
    int calculateDamageDealt(int baseDamage);
    int calculateDamageTaken(int baseDamage);
}
