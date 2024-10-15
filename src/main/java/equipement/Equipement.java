package main.java.equipement;

import main.java.enums.Effet;
import main.java.enums.Rarete;

/**
 * Représente un équipement dans le jeu. Un équipement possède des caractéristiques
 * telles que son nom, ses dégâts, son effet, sa rareté, son type et son niveau.
 *
 * @author [Votre nom]
 * @version 1.0
 */

public class Equipement {

    
    private String nom;
    private int degats;
    private Effet effet;
    private Rarete rarete;
    private TypeEquipement type;
    private int niveau;

    /**
     * Construit un nouvel équipement.
     *
     * @param nom Le nom de l'équipement.
     * @param degats Les dégâts infligés par l'équipement.
     * @param effet L'effet spécial de l'équipement.
     * @param rarete La rareté de l'équipement.
     * @param type Le type d'objet (arme, armure, etc.).
     * @param niveau Le niveau de l'équipement.
     */
    public Equipement(String nom, int degats, Effet effet, String rarete, TypeEquipement type, int niveau) {
        this.nom = nom;
        this.degats = degats;
        this.effet = effet;
        this.rarete = Rarete.valueOf(rarete.toUpperCase());
        this.type = type;
    }

    public Equipement(String nom, int degats, Effet effet, Rarete rarete, TypeEquipement type, int niveau) {
        this.nom = nom;
        this.degats = degats;
        this.effet = effet;
        this.rarete = rarete;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public int getDegats() {
        return degats;
    }

    public Effet getEffet() {
        return effet;
    }

    public String getRarete() {
        return this.rarete.toString();
    }

    public TypeEquipement getType(){
        return type;
    }

    public int getNiveau(){
        return niveau;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public void setRarete(String rarete) {
        this.rarete = Rarete.valueOf(rarete);
    }

    public void setNIveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + degats;
        result = prime * result + ((effet == null) ? 0 : effet.hashCode());
        result = prime * result + ((rarete == null) ? 0 : rarete.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + niveau;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipement other = (Equipement) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (degats != other.degats)
            return false;
        if (effet != other.effet)
            return false;
        if (rarete != other.rarete)
            return false;
        if (type != other.type)
            return false;
        if (niveau != other.niveau)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return nom + "(" + this.getType().toString() + ")";
    }
}
