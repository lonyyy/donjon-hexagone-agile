package main.java.classes;

import java.util.List;

import main.java.competence.Competence;
import main.java.equipement.Equipement;

/**
 * Cette classe représente une classe de base possédant une vie et une force.
 * Elle peut servir de base pour créer des classes plus spécifiques,
 */
public class Classes {

    /**
     * La quantité de vie de la classe.
     */
    private int vie;

    /**
     * La force de la classe.
     */
    private int force;

    /**
     * L'équipement associé à la classe.
     */
    private Equipement equip;

    private List<Competence> liste_competence;
    /**
     * Constructeur de la classe.
     *
     * @param vie   La valeur initiale de la vie.
     * @param force La valeur initiale de la force.
     */
    public Classes(Equipement equip,int vie, int force,List<Competence> liste_competence) {
        this.equip = equip;
        this.vie = vie;
        this.force = force;
        this.liste_competence = liste_competence;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public Equipement getEquip() {
        return equip;
    }

    public void setEquip(Equipement equip) {
        this.equip = equip;
    }

    public List<Competence> getListe_competence() {
        return liste_competence;
    }

    public void setListe_competence(List<Competence> liste_competence) {
        this.liste_competence = liste_competence;
    }

    /**
     * @return La quantité de vie actuelle.
     */
    public int getVie() {
        return vie;
    }

    /**
     * @return La force actuelle.
     */
    public int getForce() {
        return force;
    }

    /**
     * @return l'équipement actuelle associé à la classe.
     */
    public Equipement getEquipement() {
        return this.equip;
    }
    
}