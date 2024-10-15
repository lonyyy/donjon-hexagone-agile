package main.java.classes;

import java.util.ArrayList;
import java.util.List;

import main.java.competence.Competence;
import main.java.enums.Effet;
import main.java.equipement.Baton;
import main.java.equipement.Equipement;


/**
 * Cette classe représente un mage, qui hérite de la classe de base `Classes`.
 * Un mage possède une vie, une force et un baton.
 */

public class Mage extends Classes{

    /**
     * Constructeur de la classe Mage
     * Par défaut, un mage a par défaut 3 de vie et 5 de force.
     * Initialise aussi son arme fétiche.
     */
    public Mage(){
        super(new Baton("Le bâton de Druide", 0, Effet.BONUS_MANA, "Commun", 1),3, 5,initialisation()); // Appel au constructeur de la classe parent Classes avec la vie et la force par défaut
    }

    /**
     * @return Le baton du voleur.
     */
    public Equipement getBaton(){
        return super.getEquipement();
    }

    public static List<Competence> initialisation(){
        List<Competence> l = new ArrayList<>();
        Competence c1 = new Competence(2, 30, "Vent Cévenol", Effet.REGENERATION);
        Competence c2 = new Competence(9, 80, "Brise Marine", Effet.AUCUN);
        Competence c3 = new Competence(3, 70, "Éclat de Lumière", Effet.PARALYSIE);
        Competence c4 = new Competence(1, 15, "Murmure des Âmes", Effet.BONUS_MANA);
        l.add(c1);
        l.add(c2);
        l.add(c3);
        l.add(c4);
        return l;
    }
    
}
