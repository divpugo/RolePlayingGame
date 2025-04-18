package eu.telecomnancy.rpg.patterns.visitor;

import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

public class HealVisitor implements CharacterVisitor {
    @Override
    public void visit(Warrior warrior) {
        int healAmount = 25; 
        int maxHealth = 100; 
        int newHealth = Math.min(maxHealth, warrior.getHealth() + healAmount);
        warrior.setHealth(newHealth); 
        System.out.println(warrior.getName() + " a ete gueri ! Sante actuel : " + warrior.getHealth());
    }

    @Override
    public void visit(Wizard wizard) {
        int healAmount = 20; 
        int maxHealth = 80; 
        int newHealth = Math.min(maxHealth, wizard.getHealth() + healAmount);
        wizard.setHealth(newHealth); 
        System.out.println(wizard.getName() + " a ete gueri ! Sante actuel : " + wizard.getHealth());
    }
}
