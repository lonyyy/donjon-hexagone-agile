package main.java.competence;

import main.java.entite.Entite;
import main.java.entite.Joueur;
import main.java.enums.Effet;

public class Competence {
    
    private int degat;
    private String nom;
    private Effet effet;
    private int cout;
    
    public Competence(int degat,int cout ,String nom, Effet effet){
        this.degat = degat;
        this.cout = cout;
        this.nom = nom;
        this.effet = effet;
    }

    public int getDegat() {
        return degat;
    }

    public String getNom() {
        return nom;
    }

    public Effet getEffet() {
        return effet;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void utiliser(Entite other, Joueur j){
        other.setVieRestante(other.getVieRestante() - (this.degat+j.totalForce()));
        System.out.println("Vous avez utiliser " + this.nom + ", vous infligez " + (this.degat+j.totalForce()) + " degats");
    }
    
    public String toString(){
        if (this.effet.equals(Effet.AUCUN)){
            return "La compétence " + this.nom + " fait " + this.degat + " points de dégats, coûte " + this.cout + " points de mana et n'applique aucun effet";
        }
        else{
            return "La compétence " + this.nom + " fait " + this.degat + " points de dégats, coûte " + this.cout + " points de mana et applique l'effet "+this.effet.toString();
        }
    }
}
