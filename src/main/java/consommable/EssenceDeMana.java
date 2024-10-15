package main.java.consommable;

import main.java.entite.Joueur;
import main.java.enums.Effet;
import main.java.enums.Rarete;

public class EssenceDeMana extends Consommable implements Essence{

    private boolean estDisponible;

    public EssenceDeMana (Rarete rarete, String nom, Effet effet, int bonus){
        super(rarete, nom, effet, bonus);
        this.estDisponible = true;
    }

    /** La fonction ajoute un bonus de mana permanent au joueur
     * @param joueur
     */
    @Override
    public void utiliserEssence(Joueur joueur) {
        if(estDisponible==true){
            joueur.setMana(joueur.getMana()+this.getBonus());
            this.estDisponible=false;
            joueur.enleverDeLinventaire(this);
        }
    }
}
