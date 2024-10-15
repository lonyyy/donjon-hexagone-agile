package main.java.classes;

import java.util.ArrayList;
import java.util.List;

import main.java.competence.Competence;
import main.java.enums.Effet;
import main.java.equipement.Dague;
import main.java.equipement.Equipement;


/**
 * Cette classe représente un voleur, qui hérite de la classe de base `Classes`.
 * Un voleur possède une vie, une force et une dague.
 */

public class Voleur extends Classes {

    /**
     * Constructeur de la classe Voleur
     * Par défaut, un voleur a par défaut 2 de vie et 6 de force.
     * Initialise aussi son arme fétiche.
     */
    public Voleur(){
        super(new Dague("La Fleur de Lys", 6, Effet.SAIGNEMENT, "Commun", 1),2, 6,initialisation()); // Appel au constructeur de la classe parent Classes avec la vie et la force par défaut
    }

    /**
     * @return La dague du voleur.
     */
    public Equipement getDague(){
        return super.getEquipement();
    }

    public static List<Competence> initialisation(){
        List<Competence> l = new ArrayList<>();
        Competence c1 = new Competence(5, 0, "Éclair de Lame", Effet.BONUS_VITESSE);
        Competence c2 = new Competence(6, 0, "Ombre Danseuse", Effet.SAIGNEMENT);
        l.add(c1);
        l.add(c2);
        return l;
    }
}
