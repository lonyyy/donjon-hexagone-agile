package main.java.equipement;

import main.java.enums.Effet;

    /**
 * Représente un arc, une arme à distance utilisée pour tirer des projectiles. 
 * Un arc possède des caractéristiques telles qu'un nom, des dégâts, un effet spécial, une rareté et un niveau.
 */

public class Arc extends Equipement{

    /**
     * Construit une nouvelle instance d'arc avec les caractéristiques spécifiées.
     *
     * @param nom     Le nom de l'arc.
     * @param degats  Les dégâts de base infligés par l'arc.
     * @param effet   L'effet spécial associé à l'arc (par exemple, empoisonnement des flèches).
     * @param rarete  La rareté de l'arc (commun, rare, épique, etc.).
     * @param niveau  Le niveau requis pour utiliser l'arc.
     */
    public Arc(String nom, int degats, Effet effet, String rarete, int niveau){
        super(nom, degats, effet, rarete, TypeEquipement.BOUCLIER, niveau);
    }

    public String getNom() {
        return super.getNom();
    }
    public void setNom(String nom) {
        super.setNom(nom);;
    }
    public int getDegats() {
        return super.getDegats();
    }
    public void setDegats(int degats) {
        super.setDegats(degats);;
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
