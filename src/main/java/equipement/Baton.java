package main.java.equipement;

import main.java.enums.Effet;
import main.java.enums.Rarete;

/**
 * Représente un bâton, une arme de magie utilisée par les mages pour canaliser leurs sorts.
 * Un bâton peut avoir des caractéristiques telles que des dégâts de base (pour le combat rapproché), un effet spécial magique, une rareté et un niveau requis pour l'utiliser.
 */
public class Baton extends Equipement{

        /**
     * Construit une nouvelle instance de bâton avec les caractéristiques spécifiées.
     *
     * @param nom     Le nom du bâton.
     * @param degats  Les dégâts de base infligés en combat rapproché (peuvent être faibles).
     * @param effet   L'effet spécial magique associé au bâton (par exemple, bonus de dégâts de feu).
     * @param rarete  La rareté du bâton (commun, rare, épique, etc.).
     * @param niveau  Le niveau requis pour utiliser le bâton.
     */
    
    public Baton(String nom, int degats, Effet effet, String rarete, int niveau){
        super(nom, degats, effet, rarete, TypeEquipement.BATON, niveau);
    }
    public Baton(String nom, int degats, Effet effet, Rarete rarete, int niveau){
        super(nom, degats, effet, rarete, TypeEquipement.BATON, niveau);
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
