package main.java;


import java.util.Scanner;
import java.io.IOException;

import main.java.entite.Joueur;

public class Interface {

  private static final int IDX_STATS = 1;

  /**
   * Afficher l'interface de jeu
   * @throws IOException 
   */
  void afficherInterface() throws IOException {
    System.out.println("-----------------------------");

    // TODO: Récupérer la classe du joueur
    String classeJoueur = "Guerrier";

    System.out.print("> " + classeJoueur + " / ");

    // TODO: Récupérer la vie du joueur et le maximum de sa vie
    int maxVieJoueur = 50;
    int vie = 5;

    for (int i = 0; i < maxVieJoueur; i++) {
      if (i >= vie) {
        System.out.print("♡");
      } else {
        System.out.print("♥");
      }
    }

    System.out.println("\n-----------------------------");
    System.out.println(IDX_STATS + ". Statistiques");

    ecouterClavier();
  }

  /**
   * Ecoute les entrées au clavier de l'utilisateur pour qu'il choisisse ce qu'il veut faire
   * @throws IOException 
   */
  void ecouterClavier() throws IOException {
    int choice = -1;

    Scanner sc = new Scanner(System.in);
    choice = OutilsDev.entree_entier(sc);

    if (choice < 1 || choice > 1) {
      afficherInterface();

      sc.close();

      return;
    }

    if (choice == IDX_STATS) {
      // TODO: Récupérer les stats du joueur
      int force = 10;
      int vitesse = 3;
      int mana = 5;

      System.out.println("----- Statistiques -----");
      System.out.println("Force : " + force);
      System.out.println("Vitesse : " + vitesse);
      System.out.println("Mana : " + mana);
      System.out.println("------------------------");
    }

    afficherInterface();

    sc.close();
  }

  public static void afficherInventaire(Joueur j){
      String c = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/donjon/inventaire.txt");
      System.out.println(c);
    if (j.tailleInventaire() > 0) {
      for(int i = 1; i < j.tailleInventaire(); i++){
        System.out.println(i + "." + j.getInventaire());
      }
    }else{
      System.out.println("Votre inventaire est vide :)");
    }
  }

  public static void afficherCompetence(Joueur j){
    j.afficherCompetence();
  }

  /**
   * Afficher le fonctionnement du jeu
   */
  public static void afficherFonctionnement() {
    String content = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/menu/fonctionnement.txt");
    System.out.println(content + "\n");

}
}
