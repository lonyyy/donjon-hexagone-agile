package main.java.entite;

import java.io.Serializable;
import java.util.HashMap;

import main.java.OutilsDev;
import main.java.classes.Classes;
import main.java.consommable.Consommable;
import main.java.equipement.Equipement;

public class Joueur extends Entite implements Serializable{
  private static final long serialVersionUID = 1;

  private HashMap<Stats, Integer> statsBonus;
  private HashMap<Consommable,Integer> inventaire;
  private Classes classe;
  private Equipement mainDirect;
  private int etage;
  private int posX;
  private int posY;

  public Joueur(String nom, int force, int vie, int vitesse, int mana, String sprite, Classes classe, Equipement mainDirect, int etage, int posX, int posY){
    super(nom, force, vie, vitesse, mana, sprite);
    HashMap<Stats, Integer> hm = new HashMap<>();
    hm.put(Stats.FORCE, force);
    hm.put(Stats.VIE, vie);
    hm.put(Stats.VITESSE, vitesse);
    hm.put(Stats.MANA, mana);
    this.statsBonus = hm;
    this.inventaire = new HashMap<>();
    this.classe = classe;
    this.etage = etage;
    this.posX = posX;
    this.posY = posY;
    this.mainDirect = mainDirect;
  }

  public Joueur(String nom, int force, int vie, int vitesse, int mana, String sprite, Classes classe, Equipement mainDirect){
    this(nom, force, vie, vitesse, mana, sprite, classe, mainDirect, 1, 0, 0);
  }

  public int getForceBonus() {
    return this.statsBonus.get(Stats.FORCE);
  }

  public void setForceBonus(int force) {
    this.statsBonus.put(Stats.FORCE, force);
  }

  public int getVieBonus() {
    return this.statsBonus.get(Stats.VIE);
  }

  public void setVieBonus(int vie) {
    this.statsBonus.put(Stats.VIE, vie);
  }

  public int getVitesseBonus() {
    return this.statsBonus.get(Stats.VITESSE);
  }

  public void setVitesseBonus(int vitesse) {
    this.statsBonus.put(Stats.VITESSE, vitesse);
  }

  public int getManaBonus() {
    return this.statsBonus.get(Stats.MANA);
  }

  public HashMap<Consommable,Integer>  getInventaire() {
    return this.inventaire;
  }

  public void setInventaire(HashMap<Consommable,Integer> inventaire) {
    this.inventaire = inventaire;
  }

  public Classes getClasse() {
    return classe;
  }

  /**Permet d'appliquer une classe a un joueur
   * @param classe
   */
  public void setClasse(Classes classe) {
    if (this.classe == null) {
      this.classe = classe;
      this.setForceBonus(classe.getForce());
      this.setVieBonus(classe.getVie());
      this.mainDirect = classe.getEquipement();
    }
  }

  public void aficherInventaire(){
      String c = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/interface_competences.txt");
      System.out.println(c);
    for (Consommable consommable : inventaire.keySet()) {
      System.out.println(consommable + " x" + inventaire.get(consommable));
    }
  }
  
  public void setManaBonus(int mana) {
    this.statsBonus.put(Stats.MANA, mana);
  }

  public int getEtage() {
    return etage;
  }

  public void setEtage(int etage) {
    this.etage = etage;
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public Equipement getMainDirect() {
    return mainDirect;
  }

  public void setMainDirect(Equipement mainDirect) {
    this.mainDirect = mainDirect;
    this.statsBonus.put(Stats.FORCE, mainDirect.getDegats());
  }
  
  /**Permet d'attaquer une entité avec sa force
   * @param other
   */
  public void attaquer(Entite other) {
    if (this.critCheck()) {
      other.setVieRestante(other.getVieRestante() - (int)(this.totalForce()*1.5));
    }else{
      other.setVieRestante(other.getVieRestante() - this.totalForce());
    }
  }

  /**Fait le cumule des forces (Bonus et Normal)
   * @return
   */
  public int totalForce() {
    return this.getForce() + this.getForceBonus();
  }

  /**Fait le cumule des vie (Bonus et Normal)
 * @return
 */
  public int totalVie() {
    return this.getVie() + this.getVieBonus();
  }

  /**Fait le cumule des vitesse (Bonus et Normal)
   * @return
   */
  public int totalVitesse() {
    return this.getVitesse() + this.getVitesseBonus();
  }

  /**Fait le cumule des mana (Bonus et Normal)
   * @return
   */
  public int totalMana() {
    return this.getMana() + this.getMana();
  }

  /**Permet de placer un item dans l'inventaire
   * @param item
   */
  public void stockerDansLinventaire(Consommable conso){
    if (inventaire.containsKey(conso)) {
      inventaire.put(conso, inventaire.get(conso)+1);
    }else{
      this.inventaire.put(conso,1);
    }
  }

  /**Permet d'enlever un item dans l'inventaire
   * @param item
   */
  public void enleverDeLinventaire(Consommable conso){
    this.inventaire.remove(conso);
  }

  /**Vide completement l'inventaire
   * 
   */
  public void clearInventaire(){
    this.inventaire.clear();
  }

  /**Permet de d'avoir la taille de l'inventaire
   * @return
   */
  public int tailleInventaire(){
    return this.inventaire.size();
  }

  public void changerDeDirecte(Equipement other){
    this.mainDirect = other;
    System.out.println("Vous avez changer d'arme pour " + other.toString());
  }
  public void afficherCompetence(Joueur this){
    String c = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/combat/competences.txt");
    System.out.println(c);

    if (this.classe.getListe_competence().size() > 0) {
      for(int i = 1; i < this.classe.getListe_competence().size() + 1; i++){
        System.out.println(i + "." + this.classe.getListe_competence().get(i-1).getNom());
        if (this.classe.getListe_competence().get(i-1).getCout() > 1) {
          System.out.print("Coût: " + this.classe.getListe_competence().get(i-1).getCout());
        }
        System.out.print(" Dégat(s): " + this.classe.getListe_competence().get(i-1).getDegat());
        System.out.println(" Effet: " + this.classe.getListe_competence().get(i-1).getEffet().name());
        System.out.println("(" + this.classe.getListe_competence().get(i-1).toString() + ")");
        System.out.println();
      }
    }else{
      System.out.println("Vous n'avez pas de compétence(s) (dommage)");
    }
  }
}
