package eu.telecomnancy.rpg.patterns.visitor;

import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

public class DamageVisitor implements CharacterVisitor {
    @Override
    public void visit(Warrior warrior) {
        int damageAmount = 20; 
        int newHealth = Math.max(0, warrior.getHealth() - damageAmount);
        warrior.setHealth(newHealth);
        System.out.println(warrior.getName() + " a subi des degats ! Sante restante : " + warrior.getHealth());
    }

    @Override
    public void visit(Wizard wizard) {
        int damageAmount = 15; 
        int newHealth = Math.max(0, wizard.getHealth() - damageAmount);
        wizard.setHealth(newHealth);
        System.out.println(wizard.getName() + " a subi des degats ! Sante restante : " + wizard.getHealth());
    }
}
