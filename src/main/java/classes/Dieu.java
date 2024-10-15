package main.java.classes;


import java.util.ArrayList;
import java.util.List;

import main.java.competence.Competence;
import main.java.enums.Effet;
import main.java.enums.Rarete;
import main.java.equipement.Baton;
import main.java.equipement.Equipement;
/**
 * Cette classe représente un Dieu, qui hérite de la classe de base `Classes`.
 * Un Dieu possède une vie, une force et un bouclier.
 */

public class Dieu extends Classes {


    /**
     * Constructeur de la classe Dieu.
     * Par défaut, un Dieu a 1 points de vie et 1000 points de force.
     * Initialise aussi son gros bâton.
     */
    public Dieu() {
        super(new Baton("tit' callis", 1000, Effet.REGENERATION, Rarete.UNIQUE, 1000),1,1000,initialisation()); // Appel au constructeur de la classe parent Classes avec la vie et la force par défaut
    }

    /**
     * @return le bouclier du Dieu
     */
    public Equipement Prier() {
        return super.getEquipement();
    }

    public static List<Competence> initialisation(){
        List<Competence> l = new ArrayList<>();
        Competence c1 = new Competence(1000, 0, "La french touch reunault", Effet.BONUS_VIE);
        Competence c2 = new Competence(2000, 1000, "Pipi pluie", Effet.REGENERATION);
        Competence c3 = new Competence(3000, 1, "Gérard deux par deux", Effet.BONUS_FORCE);
        Competence c4 = new Competence(0, 1000, "Ramenez la coupe à la maison", Effet.BONUS_VITESSE);

        l.add(c1);
        l.add(c2);
        l.add(c3);
        l.add(c4);

        return l;
    }
}