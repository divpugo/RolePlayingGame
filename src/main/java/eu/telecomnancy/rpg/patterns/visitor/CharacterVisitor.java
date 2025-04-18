package eu.telecomnancy.rpg.patterns.visitor;

import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;

public interface CharacterVisitor {
    void visit(Warrior warrior);
    void visit(Wizard wizard);
}
