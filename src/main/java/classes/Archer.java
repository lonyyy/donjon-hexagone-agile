package main.java.classes;

import java.util.ArrayList;
import java.util.List;

import main.java.competence.Competence;
import main.java.enums.Effet;
import main.java.equipement.Arc;
import main.java.equipement.Equipement;


/**
 * Cette classe représente un archer, qui hérite de la classe de base `Classes`.
 * Un archer possède une vie, une force et un arc.
 */

public class Archer extends Classes{

    /**
     * Constructeur de la classe Archer.
     * Par défaut, l'archer a 4 points de vie et 4 points de force.
     * Initialise aussi son arme fétiche.
     */
    public Archer() {
        super(new Arc("Le Corbeau", 4, Effet.PARALYSIE, "Commun", 1),4,4, initialisation()); // Appel au constructeur de la classe parent Classes avec la vie et la force par défaut
    }

    /**
     * @return L'arc de l'archer.
     */
    public Equipement getArc() {
        return super.getEquipement();
    }

    public static List<Competence> initialisation(){
        List<Competence> l = new ArrayList<>();
        Competence c1 = new Competence(4, 0, "Pluie de flèches", Effet.BONUS_FORCE);
        Competence c2 = new Competence(5, 0, "Flèche d'Apollon", Effet.AUCUN);
        l.add(c1);
        l.add(c2);
        return l;
    }
}