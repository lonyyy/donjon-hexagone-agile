package main.java.equipement;

import main.java.enums.Effet;

/**
 * Représente une dague, un type d'équipement utilisé principalement pour infliger des dégâts en mêlée.
 * Une dague possède des caractéristiques spécifiques telles que des dégâts de base, un effet spécial, une rareté et un niveau.
 * Elle hérite de la classe abstraite `Equipement` et en implémente les méthodes.
 */

public class Dague extends Equipement{

    /**
     * Construit une nouvelle instance de dague avec les caractéristiques spécifiées.
     *
     * @param nom     Le nom de la dague.
     * @param degats  Les dégâts de base infligés par la dague.
     * @param effet   L'effet spécial associé à la dague (par exemple, empoisonnement).
     * @param rarete  La rareté de la dague (commun, rare, épique, etc.).
     * @param niveau  Le niveau requis pour utiliser la dague.
     */
    
    public Dague(String nom, int degats, Effet effet, String rarete, int niveau){
        super(nom, degats, effet, rarete, TypeEquipement.DAGUE, niveau);
    }

    public String getNom() {
        return super.getNom();
    }


    public void setNom(String nom) {
        super.setNom(nom);
    }


    public int getDegats() {
        return super.getDegats();
    }


    public void setDegats(int degats) {
        super.setDegats(degats);
    }


    public Effet getEffet() {
        return super.getEffet();
    }


    public void setEffet(Effet effet) {
        super.setEffet(effet);
    }


    public String getRarete() {
        return super.getRarete();
    }


    public void setRarete(String rarete) {
        super.setRarete(rarete);
    }
}

