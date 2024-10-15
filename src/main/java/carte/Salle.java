package main.java.carte;

import java.io.Serializable;

public class Salle implements Serializable{
  private static final long serialVersionUID = 1;

  boolean contientMonstre;
  boolean estBoss;
  boolean contientCoffre;
  boolean[] portes = new boolean[4];

  boolean monstreEnVie;

  int positionX;
  int positionY;

  public Salle(
    boolean contientCoffre,
    boolean contientMonstre,
    boolean estBoss,
    // Haut => droit => bas => gauche

    boolean[] portes,
    int positionX,
    int positionY
  ) {
    this.contientCoffre = contientCoffre;
    this.contientMonstre = contientMonstre;
    this.estBoss = estBoss;
    this.portes = portes;
    this.positionX = positionX;
    this.positionY = positionY;
  }

  public boolean contientCoffre() {
    return contientCoffre;
  }

  public boolean contientMonstre() {
    return contientMonstre;
  }

  public boolean estBoss() {
    return estBoss;
  }

  public boolean[] getPortes() {
    return portes;
  }

  public void setMonstreEnVie(boolean monstreEnVie) {
    this.monstreEnVie = monstreEnVie;
  }

  public boolean isContientMonstre() {
    return contientMonstre;
  }

  public void setContientMonstre(boolean contientMonstre) {
    this.contientMonstre = contientMonstre;
  }

  public boolean isEstBoss() {
    return estBoss;
  }

  public void setEstBoss(boolean estBoss) {
    this.estBoss = estBoss;
  }

  public boolean isContientCoffre() {
    return contientCoffre;
  }

  public void setContientCoffre(boolean contientCoffre) {
    this.contientCoffre = contientCoffre;
  }

  public void setPortes(boolean[] portes) {
    this.portes = portes;
  }

  public boolean isMonstreEnVie() {
    return monstreEnVie;
  }

  public int getPositionX() {
    return positionX;
  }

  public void setPositionX(int positionX) {
    this.positionX = positionX;
  }

  public int getPositionY() {
    return positionY;
  }

  public void setPositionY(int positionY) {
    this.positionY = positionY;
  }
}
