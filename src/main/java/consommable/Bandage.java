package main.java.consommable;

import main.java.entite.Joueur;
import main.java.enums.Effet;
import main.java.enums.Rarete;

public class Bandage extends Consommable {

  private boolean estDisponible;

  public Bandage(Rarete rarete, String nom, Effet effet, int bonus) {
    super(rarete, nom, effet, bonus);
    this.estDisponible = true;
  }

  /**La fonction permet de redonner un nombre de point de vie égal au bonus du bandage
   * @param joueur
   */
  public void utiliserBandage(Joueur joueur) {
    if (estDisponible == true) {
      if (joueur.getVie() - joueur.getVieRestante() < this.getBonus()) {
        joueur.setVieRestante(joueur.getVie());
      } else {
        joueur.setVieRestante(joueur.getVieRestante() + this.getBonus());
      }
      estDisponible = false;
    }
  }
}
