package main.java.equipement;

import main.java.enums.Effet;
import main.java.enums.Rarete;

/**
 * Représente un bouclier, un équipement défensif utilisé pour réduire les dégâts subis.
 * Un bouclier possède des caractéristiques telles qu'un nom, une rareté, un niveau et peut conférer des effets spéciaux.
 */

public class Bouclier extends Equipement{

    /**
     * Construit une nouvelle instance de bouclier avec les caractéristiques spécifiées.
     *
     * @param nom     Le nom du bouclier.
     * @param effet   L'effet spécial associé au bouclier (par exemple, absorption des dégâts magiques).
     * @param rarete  La rareté du bouclier (commun, rare, épique, etc.).
     * @param niveau  Le niveau requis pour utiliser le bouclier.
     */
    
    public Bouclier(String nom, int degats, Effet effet, String rarete, int niveau){
        super(nom, degats, effet, rarete, TypeEquipement.BOUCLIER, niveau);
    }
    public Bouclier(String nom, int degats, Effet effet, Rarete rarete, int niveau){
        super(nom, degats, effet, rarete, TypeEquipement.BOUCLIER, niveau);
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
