package main.java.consommable;

import main.java.entite.Joueur;
import main.java.enums.Effet;
import main.java.enums.Rarete;

public class EssenceDeVie extends Consommable implements Essence{

    private boolean estDisponible;

    public EssenceDeVie (Rarete rarete, String nom, Effet effet, int bonus){
        super(rarete, nom, effet, bonus);
        this.estDisponible = true;
    }

    /**La fonction ajoute un bonus de vie permanent au joueur
     * @param joueur
     */
    public void utiliserEssence(Joueur joueur){
        if(estDisponible==true){
            joueur.setVie(joueur.getVie()+this.getBonus());
            this.estDisponible=false;
            joueur.enleverDeLinventaire(this);
        }
    }
}