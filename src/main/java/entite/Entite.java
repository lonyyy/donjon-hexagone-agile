package main.java.entite;

import java.util.HashMap;
import java.util.Random;

public abstract class Entite {

  private String nom;
  private HashMap<Stats, Integer> stats;
  private int vieRestante;
  protected String sprite;
  private boolean estEnVie;
  private final Random RAND = new Random();

  public Entite(
    String nom,
    int force,
    int vie,
    int vitesse,
    int mana,
    String sprite
  ) {
    this.nom = nom;
    HashMap<Stats, Integer> hm = new HashMap<>();
    hm.put(Stats.FORCE, force);
    hm.put(Stats.VIE, vie);
    hm.put(Stats.VITESSE, vitesse);
    hm.put(Stats.MANA, mana);
    this.stats = hm;
    this.vieRestante = vie;
    this.sprite = sprite;
    this.estEnVie = true;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getForce() {
    return this.stats.get(Stats.FORCE);
  }

  public void setForce(int force) {
    this.stats.put(Stats.FORCE, force);
  }

  public int getVie() {
    return this.stats.get(Stats.VIE);
  }

  public void setVie(int vie) {
    this.stats.put(Stats.VIE, vie);
  }

  public int getVitesse() {
    return this.stats.get(Stats.VITESSE);
  }

  public void setVitesse(int vitesse) {
    this.stats.put(Stats.VITESSE, vitesse);
  }

  public int getMana() {
    return this.stats.get(Stats.MANA);
  }

  public void setMana(int mana) {
    this.stats.put(Stats.MANA, mana);
  }

  public HashMap<Stats, Integer> getStats() {
    return stats;
  }

  public void setStats(HashMap<Stats, Integer> stats) {
    this.stats = stats;
  }

  public int getVieRestante() {
    return vieRestante;
  }

  public void setVieRestante(int vieRestante) {
    this.vieRestante = vieRestante;
  }

  public String getSprite() {
    return "res/sprites/" + sprite + ".txt";
  }

  public void setSprite(String sprite) {
    this.sprite = sprite;
  }

  protected boolean critCheck(){
    int ran = RAND.nextInt(100);

    if (ran > 9) {
      return false;
    }

    return true;
  }

  /**Permet d'attaquer une entité avec sa force
   * @param other
   */
  public void attaquer(Entite other) {
    if (this.critCheck()) {
      other.setVieRestante(other.getVieRestante() - (int)(this.getForce()*1.5));
    }else{
      other.setVieRestante(other.getVieRestante() - this.getForce());
    }
  }

  /**Permet d'actuliser l'attribut "isAlive"
   *
   */
  public boolean estEnVie() {
    if (this.getVieRestante() <= 0) {
      this.estEnVie = false;
      return false;
    }

    return true;
  }

  public boolean getEstEnVie() {
    return this.estEnVie;
  }

  /**Affiche la vie de l'entité avec des coeurs
   * @return
   */
  public String afficherVie() {
    StringBuilder chaine = new StringBuilder();

    for (int i = 0; i < this.stats.get(Stats.VIE); i++) {
      if (i >= vieRestante) {
        chaine.append('♡');
      } else {
        chaine.append('♥');
      }
    }

    chaine.append(" " + this.vieRestante + "/" + this.getVie());

    return chaine.toString();
  }
}
