package main.java;

import java.util.Scanner;
import main.java.classes.Archer;
import main.java.classes.Classes;
import main.java.classes.Dieu;
import main.java.classes.Guerrier;
import main.java.classes.Mage;
import main.java.classes.Voleur;

public class ChoixClasse {

  Scanner sc = new Scanner(System.in);

  Classes choisirClasse() {
    System.out.println("=== Choisissez votre classe ===");

    System.out.println("1. Guerrier");
    System.out.println("2. Mage");
    System.out.println("3. Archer");
    System.out.println("4. Voleur\n");

    System.out.print("Votre choix : ");

    int choix = OutilsDev.entree_entier(sc);

    switch (choix) {
      case 1:
        return new Guerrier();
      case 2:
        return new Mage();
      case 3:
        return new Archer();
      case 4:
        return new Voleur();
      case 493:
        return new Dieu();
      default:
        System.out.println("Choix invalide, veuillez recommencer.");
        return choisirClasse();
    }
  }
}
