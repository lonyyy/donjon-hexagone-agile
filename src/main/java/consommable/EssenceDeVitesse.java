package main.java.consommable;

import main.java.entite.Joueur;
import main.java.enums.Effet;
import main.java.enums.Rarete;

public class EssenceDeVitesse extends Consommable implements Essence{

    private boolean estDisponible;

    public EssenceDeVitesse (Rarete rarete, String nom, Effet effet, int bonus){
        super(rarete, nom, effet, bonus);
        this.estDisponible = true;
    }

    /**La fonction ajoute un bonus de vitesse permanent au joueur
     * @param joueur
     */
    public void utiliserEssence(Joueur joueur){
        if(estDisponible==true){
            joueur.setVitesse(joueur.getVitesse()+this.getBonus());
            this.estDisponible=false;
            joueur.enleverDeLinventaire(this);
        }
    }
}