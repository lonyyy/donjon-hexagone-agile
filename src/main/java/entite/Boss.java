package main.java.entite;

import main.java.equipement.Equipement;

public class Boss extends Monstre {

  Equipement Drop;

  public Boss(
    String nom,
    int force,
    int vie,
    int vitesse,
    int mana,
    String sprite,
    Equipement drop
  ) {
    super(nom, force, vie, vitesse, mana, sprite);
    this.Drop = drop;
  }

  @Override
  public String getSprite() {
      return ("res/sprites/boss/"+sprite+".txt");
  }
}
