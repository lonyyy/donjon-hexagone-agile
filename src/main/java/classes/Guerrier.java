package main.java.classes;


import java.util.ArrayList;
import java.util.List;

import main.java.competence.Competence;
import main.java.enums.Effet;
import main.java.equipement.Bouclier;
import main.java.equipement.Equipement;
/**
 * Cette classe représente un guerrier, qui hérite de la classe de base `Classes`.
 * Un guerrier possède une vie, une force et un bouclier.
 */

public class Guerrier extends Classes {


    /**
     * Constructeur de la classe Guerrier.
     * Par défaut, un guerrier a 7 points de vie et 3 points de force.
     * Initialise aussi son arme fétiche.
     */
    public Guerrier() {
        super(new Bouclier("Le Gallic", 1, Effet.REGENERATION, "Commun", 1),7,1,initialisation()); // Appel au constructeur de la classe parent Classes avec la vie et la force par défaut
    }

    /**
     * @return le bouclier du guerrier
     */
    public Equipement getBouclier() {
        return super.getEquipement();
    }

    public static List<Competence> initialisation(){
        List<Competence> l = new ArrayList<>();
        Competence c1 = new Competence(1, 0, "Bouclier de Ymir", Effet.BONUS_VIE);
        Competence c2 = new Competence(3, 0, "Fureur de Berserker", Effet.BONUS_FORCE);
        l.add(c1);
        l.add(c2);
        return l;
    }
}