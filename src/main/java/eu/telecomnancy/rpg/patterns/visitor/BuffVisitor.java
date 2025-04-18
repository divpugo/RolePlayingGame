package eu.telecomnancy.rpg.patterns.visitor;

import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

public class BuffVisitor implements CharacterVisitor {
    @Override
    public void visit(Warrior warrior) {
        int buffAmount = 10; 
        warrior.setStrength(warrior.getStrength() + buffAmount);
        System.out.println(warrior.getName() + " a ete ameliore ! Puissance : " + warrior.getStrength());
    }

    @Override
    public void visit(Wizard wizard) {
        int buffAmount = 15; 
        wizard.setIntelligence(wizard.getIntelligence() + buffAmount);
        System.out.println(wizard.getName() + " a ete ameliore ! Intelligence : " + wizard.getIntelligence());
    }
}
