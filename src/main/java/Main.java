package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import main.java.carte.Coffre;
import main.java.carte.Etage;
import main.java.carte.Salle;
import main.java.classes.Classes;
import main.java.classes.Dieu;
import main.java.classes.Voleur;
import main.java.competence.Competence;
import main.java.entite.Boss;
import main.java.entite.Entite;
import main.java.entite.Joueur;
import main.java.entite.Monstre;
import main.java.equipement.Equipement;
import main.java.equipement.TypeEquipement;

public class Main {

  private static final Random RAN = new Random();

  private static int vie = 5;
  private static Scanner sc;
  private static Joueur joueur;
  private static final ArrayList<Etage> LISTE_ETAGE = new ArrayList<>();
  private static final int NB_ETAGE = 6; // BOSS 6
  private static int numero_etage;
  private static ArrayList<Monstre> monstres_d_etage;
  private static ArrayList<Boss> liste_Bosses;
  private static Coffre coffre = new Coffre();


  static int x;
  static int y;

  /**
   * Nettoyer la console
   */
  public static void clearScreen() {
    for (int i = 0; i < 100; i++) {
      System.out.print("\n");
      System.out.flush();
    }
  }

  public static void appuyerSurEntree() {
    // Attendre que l'utilisateur appuie sur "Entrée"
    System.out.println("Appuyez sur Entrée pour continuer...");
    sc = new Scanner(System.in);
    sc.nextLine(); // Lire la ligne pour attendre l'appui sur "Entrée"
  }

  /**
   * Lancer le combat
   * 
   */
  private static void lancerCombat(Monstre mon){
    clearScreen();

      // Affichage du monstre
      String mon_sprite = OutilsDev.chemineEnChaineDeCharacteres(mon.getSprite());
      System.out.println(mon_sprite);
      String debut_combat = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/combat/debut_combat.txt");
      System.out.println(debut_combat);


      
    appuyerSurEntree();

    boolean fuite = true;
    afficherInterfaceCombat(mon);

    while (joueur.estEnVie() && mon.estEnVie() && fuite) {
      // Déterminer qui attaque en premier en fonction de la vitesse
      Entite premierAttaquant = joueur.totalVitesse() >= mon.getVitesse()
        ? joueur
        : mon;
      Entite secondAttaquant = premierAttaquant == joueur ? mon : joueur;

      // Tour du premier attaquant
      effectuerActionCombat(premierAttaquant, secondAttaquant);
      if (!secondAttaquant.estEnVie()) break; // Si le second attaquant est mort après l'attaque du premier

      // Tour du second attaquant
      effectuerActionCombat(secondAttaquant, premierAttaquant);
      if (!premierAttaquant.estEnVie()) break; // Si le premier attaquant est mort après l'attaque du second

      // Interface de fin de tour
      afficherInterfaceCombat(mon);
    }
    String mort = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/combat/mort.txt");
    String vaincu = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/combat/vaincu.txt");
    clearScreen();
    if (!fuite) {
      if (joueur.estEnVie()) {
        System.out.println("Vous avez pris la fuite...");
        afficherInterfaceMonstre( getSalleActuelle());
      } 
    } else {
      if (joueur.estEnVie() && !mon.estEnVie()) {
        if (getSalleActuelle().estBoss()) {
          System.out.println(mon_sprite);
          System.out.println(mort);
          System.out.println("Victoire !");
        }else{
          monstres_d_etage.remove(mon);
          System.out.println(mon_sprite);
          System.out.println(mort);
          System.out.println("Victoire !");
          appuyerSurEntree();
          afficherInterfaceBase();
        }
        

      } else if (!joueur.estEnVie()) {
        System.out.println(mon_sprite);
        System.out.println(vaincu);
        appuyerSurEntree();
        x= 0;
        y=0;
        numero_etage = 0;
        // Gérer la défaite
        if (vie<0) {
          try {
            String game_over = Files.readString(
              Paths.get("res/interfaces/fin/game_over.txt")
            );
            System.out.println(game_over);
            sc = new Scanner(System.in);
            System.out.println("Voulez-vous recommencez ? o/n");
            appuyerSurEntree();
          } catch (Exception e) {
            e.getStackTrace();
  
            afficherMenuDepart();
          }
        }
        
      }
    }
  }

  /**
   * Afficher l'interface de combat
   * @param mon : (le monstre à combattre)
   */
  private static void afficherInterfaceCombat(Monstre mon) {
    try {
      String interface_combat = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/combat/interface_combat.txt");
      String mon_sprite = OutilsDev.chemineEnChaineDeCharacteres(mon.getSprite());

      clearScreen();
      System.out.println(mon_sprite);
      System.out.println(interface_combat);
      System.out.println(
        joueur.getNom() +
        " - Vie: " +
        joueur.afficherVie() +
        " (" +
        joueur.getVieRestante() +
        "/" +
        joueur.getVie() +
        ")"
      );
      System.out.println(
        mon.getNom() +
        " - Vie: " +
        mon.afficherVie() +
        " (" +
        mon.getVieRestante() +
        "/" +
        mon.getVie() +
        ")"
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Lancer le jeu
   * 
   */
  public static void demarrerJeu(){
    String intro = OutilsDev.chemineEnChaineDeCharacteres("res/dialogue/intro.txt");
    System.out.println(intro);

    sc = new Scanner(System.in);
    String nom;
    String confirmation;

    do {
        System.out.println("Jeune héros, comment vous appelez-vous ? :");
        nom = sc.nextLine();
        
        System.out.println("Vous vous appelez " + nom + ". Êtes-vous sûr ? (y/n)");
        confirmation = sc.nextLine().toLowerCase();
        
    } while (!confirmation.equals("y"));

    switch (nom) {
      case "49-3":
      joueur = new Joueur("Admin", 493, 493, 493, 493, "slime", new Dieu(), null);

        break;
      case "lepen":
        joueur = new Joueur("rebeu", 3003, 3003, 3003, 3003, "slime", new Voleur(), null);
  
          break;
      default:
        joueur = new Joueur(nom, 10, 20, 10, 0, "slime", null, null);

        break;
    }
    System.out.println("Bienvenue " + joueur.getNom() + " !");
    appuyerSurEntree();

    //choisir une classe
    if (joueur.getClasse() == null) {
      Classes classe = new ChoixClasse().choisirClasse();
      joueur.setClasse(classe); // il gagne ses stats de classe

      System.out.println(
      "Vous avez choisit la classe des " +
      joueur.getClasse().getClass().getSimpleName() +
      "s, Bonne chance !"
      );
      appuyerSurEntree();
    }
    
    

    clearScreen();

    // Instanciation étages et du placement
    x = 0;
    y = 0;

    creationListeSalles();
    creationListeBoss();

    for (numero_etage = 1; numero_etage < NB_ETAGE + 1 ; numero_etage++) {

      creationListeMonstre();


      afficherInterfaceBase();
      // réinitilalisation des positions
      x= 0;
      y=0;

    }


  }

public static void afficherInterfaceBase(){
  clearScreen();
  afficherSalle();
  try {
    String base = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/donjon/base.txt");
    System.out.println(base);
  } catch (Exception e) {
    e.getStackTrace();
  }
  int choix = OutilsDev.entree_entier(sc);

  switch (choix) {
    case 1:
      // inventaire(bool en combat)
      // System.out.println("option non implémentée");
      Interface.afficherInventaire(joueur);
      appuyerSurEntree();
      afficherInterfaceBase();
      break;
    case 2:
      Salle actuelle = getSalleActuelle();
      changerDeSalle();
      getProchaineSalle(actuelle);
      break;
    case 493:
      if (joueur.getNom().equals("Admin") && joueur.getClasse() instanceof Dieu) {
        numero_etage += 1;
        afficherInterfaceBase();
      }else{
        System.err.println("Nuh uh, cette option est réservé aux créateurs");
      }
      break;
      case 1408:
      if (joueur.getNom().equals("Admin") && joueur.getClasse() instanceof Dieu) {
        numero_etage -= 1;
        afficherInterfaceBase();
      }else{
        System.err.println("Nuh uh, cette option est réservé aux créateurs");
      }
    default:
      System.out.println("Choix invalide.");
      afficherInterfaceBase();
      break;
  }
}
public static void getProchaineSalle(Salle actuelle)  {
  try {
      if (getSalleActuelle().contientMonstre()) {
        afficherInterfaceMonstre(actuelle);
      } else if (getSalleActuelle().contientCoffre()) {
        afficherInterfaceButin(actuelle); 
      } else {
        afficherInterfaceBase();
      }
  } catch (Exception e) {
    System.err.println(e.getStackTrace());
    }


}
public static void afficherInterfaceMonstre(Salle precedente){
  clearScreen();
  afficherSalle();   
  try {
    String monstre = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/donjon/monstre.txt");
    System.out.println(monstre);
  } catch (Exception e) {
    e.getStackTrace();
  }
  int choix = OutilsDev.entree_entier(sc);

  switch (choix) {
    case 1:
      // inventaire(bool en combat)
      System.out.println("option non implémentée");
      appuyerSurEntree();
      afficherInterfaceMonstre( precedente);
      break;
    case 2:
      x = precedente.getPositionX();
      y = precedente.getPositionY();
      System.out.println("Vous êtes retourner dans la salle précédente...");
      appuyerSurEntree();
      getProchaineSalle(precedente);
    break;
    case 3:
    if(getSalleActuelle().estBoss()){
        lancerCombat(liste_Bosses.get(numero_etage-1));
    }else{
      System.out.println("Vous avez lancez le combat !");
      appuyerSurEntree();
      int mon = RAN.nextInt(monstres_d_etage.size());
      lancerCombat( monstres_d_etage.get(mon));
    }

      break;
    default:
      System.out.println("Choix invalide.");
      afficherInterfaceMonstre( precedente);
      afficherInterfaceBase();
      break;
  }
}

public static void afficherInterfaceButin( Salle precedente){
  clearScreen();
  afficherSalle();
  try {
    String butin = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/donjon/butin.txt");
    System.out.println(butin);
  } catch (Exception e) {
    e.getStackTrace();
  }
  int choix = OutilsDev.entree_entier(sc);

  switch (choix) {
    case 1:
      // inventaire(bool en combat)
      System.out.println("option non implémentée");
      appuyerSurEntree();
      afficherInterfaceButin( precedente);
      break;
    case 2:
      changerDeSalle();
      getProchaineSalle(precedente);
      break;
    case 3:
      System.err.println("Vous avez ouvert le coffre");
      appuyerSurEntree();
      coffre.init("res/maps/etage"+numero_etage+"/csv/equipement.csv");
      Equipement eq = coffre.ButinEquipement();
      clearScreen();
      System.out.println("Vous avez obtenu : " + eq.getNom() + " !!");
      appuyerSurEntree();
      System.out.println("voulez vous changer d'équipement ?  0/1");
      int oui_non = OutilsDev.entree_entier(sc);
      if (oui_non==1 ) {
        joueur.changerDeDirecte(eq);
      }else{
        System.out.println("Vous n'avez pas équipé : " + eq.getNom() + "...");
      }
      getSalleActuelle().setContientCoffre(false);
      afficherInterfaceBase();

      break;
    default:
      System.out.println("Choix invalide.");
      afficherInterfaceBase();
      break;
  }
  clearScreen();
}

public static void changerDeSalle(){
  try {
    String changement_de_salle = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/donjon/changer_salle.txt");
    System.out.println(changement_de_salle);
  } catch (Exception e) {
    e.getStackTrace();
  }
  int choix = OutilsDev.entree_entier(sc);
  switch (choix) {
    case 1:
      passerLaPorte(0); //haut
      
      break;
    case 2:
      passerLaPorte(1); //droite

      break;
    case 3:
      passerLaPorte(2); //bas

      break;
    case 4:
      passerLaPorte(3); //gauche

      break;
    case 493:
      if (joueur.getNom().equals("Admin") && joueur.getClasse() instanceof Dieu) {
        x=1;
        y=3;
        numero_etage =5;
        afficherInterfaceBase();
      }else{
        System.err.println("Nuh uh, cette option est réservé aux créateurs");
      }
      break;
      case 1408:
      if (joueur.getNom().equals("Admin") && joueur.getClasse() instanceof Dieu) {
        x=0;
        y=0;
        numero_etage = 1;
        afficherInterfaceBase();
      }else{
        System.err.println("Nuh uh, cette option est réservé aux créateurs");
      }
      break;
    default:
      System.out.println("y\'a pas de porte caché sale fou...");
      changerDeSalle();
      break;
  }
  appuyerSurEntree();
}


  public static void passerLaPorte(int direction ) { 
    boolean est_une_porte = LISTE_ETAGE
      .get(numero_etage - 1)
      .getSalles()
      .get(x)
      .get(y)
      .getPortes()[direction];

    if (est_une_porte) {
      switch (direction) {
        case 0: //haut
          System.out.println("vous prenez la porte du haut");
          y += 1;
          break;
        case 1: //bas
          System.out.println("vous prenez la porte de droite");
          x += 1;
          break;
        case 2: //droite
          System.out.println("vous prenez la porte du bas");
          y -= 1;
          break;
        case 3: //gauche
          System.out.println("vous prenez la porte de gauche");
          x -= 1;
          break;
        default:
          System.out.println(
            "C'est un mur... Vous avez glitch dans un mur... "
          );
          break;
      }
    } else {
      System.out.println(
        "Bruh... Vous avez foncé dans un mur... Sérieux " +
        joueur.getNom() +
        " ?"
      );

    }

  }

  public static Salle getSalleActuelle() {
    return LISTE_ETAGE.get(numero_etage - 1).getSalles().get(x).get(y);
  }

  

  public static void creationListeBoss() {
    liste_Bosses = new ArrayList<Boss>();
    ArrayList<String[]> bosses_temp = OutilsDev.csvRead(
      "res/maps/boss/boss.csv"
    );
    for (String[] strings : bosses_temp) {
      liste_Bosses.add(new Boss(
          strings[0],Integer.parseInt(strings[1]),Integer.parseInt(strings[2]),Integer.parseInt(strings[3]),
          Integer.parseInt(strings[4]),strings[5],new Equipement("Un string sexy", (12+numero_etage*2), null, "rare",TypeEquipement.ARMURE , 1)));
    }
  }

  public static void creationListeMonstre() {
    monstres_d_etage = new ArrayList<Monstre>();
    System.err.println();
    ArrayList<String[]> monstres_d_etage_csv = OutilsDev.csvRead(
      "res/maps/etage" + numero_etage + "/csv/monstres.csv"
    );
    for (String[] strings : monstres_d_etage_csv) {
      monstres_d_etage.add(
        new Monstre(
          strings[0],
          Integer.parseInt(strings[1]),
          Integer.parseInt(strings[2]),
          Integer.parseInt(strings[3]),
          Integer.parseInt(strings[4]),
          strings[5]
        )
      );
    }
  }

  /**
   * Début du programme
   * @param args
   */
  public static void main(String[] args) {
    //init de tout
    sc = new Scanner(System.in);

    // affichage du menu de départ
    afficherMenuDepart();

    // fermeture finale du scanner
    sc.close();
  }

  /**
   * Affiche le menu de départ permettant de débuter le jeu et demande à l'utilisateur de choisir une option.
   */
  static void afficherMenuDepart() {
    clearScreen();
    // affichage du menu de départ

      String content = OutilsDev.chemineEnChaineDeCharacteres("res/interfaces/menu/menu_debut_continuer.txt");

      int choice = -1;

      while (choice < 1 || choice > 4) { // Assurez-vous que le menu offre trois choix
        System.out.println(content);

        choice = OutilsDev.entree_entier(sc);
      }

      switch (choice) {
        case 1:
          clearScreen();
          demarrerJeu();
          break;
        case 2:
          clearScreen();
          System.out.println("Cette option n'est pas encore implémenté");
          appuyerSurEntree();
          afficherMenuDepart();
          break;
        case 3:
          clearScreen();
          Interface.afficherFonctionnement();
          appuyerSurEntree();
          afficherMenuDepart();
          break;
        case 4:
          System.exit(0);
          break;
        default:
          System.out.println("Choix invalide. Veuillez réessayer.");
          appuyerSurEntree();
          afficherMenuDepart();
          break;
      }
  }

  private static void effectuerActionCombat(Entite attaquant, Entite defenseur){
    clearScreen();

    if (attaquant instanceof Joueur) {
        afficherInterfaceCombat((Monstre) defenseur);
        sc = new Scanner(System.in);
        int choice = OutilsDev.entree_entier(sc);

        switch (choice) {
            case 1:
                Interface.afficherCompetence((Joueur) attaquant);
                int cp = OutilsDev.entree_entier(sc);
                utiliserCompetence(cp, (Joueur) attaquant, defenseur);
                break;
            case 2:
                ((Joueur) attaquant).setVieRestante(attaquant.getVie());
                System.out.println("Vous êtes soigné.");
                break;
            case 3:
              Interface.afficherInventaire(joueur);
                break;
            case 4:
                tenterFuite(attaquant, defenseur);
                break;
            default:
                System.out.println("Choix invalide.");
                break;
        }
    } else {
        actionAutomatiqueMonstre(attaquant, defenseur);
    }
    appuyerSurEntree();
}

  private static void utiliserCompetence(int cp, Joueur joueur, Entite defenseur) {
      List<Competence> competences = joueur.getClasse().getListe_competence();
      if (cp >= 1 && cp <= competences.size()) {
          competences.get(cp - 1).utiliser(defenseur, joueur);
      } else {
          System.out.println("Il n'existe pas de compétence supplémentaire.");
      }
  }

  private static void tenterFuite(Entite attaquant, Entite defenseur){
      Random random = new Random();
      int chanceFuite = random.nextInt(100);
      int seuilFuite = (attaquant.getVitesse() < defenseur.getVitesse()) ? 25 : 75;
  
      if (chanceFuite < seuilFuite) {
          System.out.println("Vous avez réussi à fuir !");
          afficherInterfaceBase();
      } else {
          System.out.println("Vous avez échoué à fuir !");
          attaquant.attaquer(defenseur);
      }
  }
  
  private static void actionAutomatiqueMonstre(Entite attaquant, Entite defenseur){
      Random rand = new Random();
      int chance = rand.nextInt(100);
  
      if (chance < 10) { // 10% de chance de se soigner
          attaquant.setVieRestante(Math.min(attaquant.getVieRestante() + attaquant.getVie() / 2, attaquant.getVie()));
          afficherMonstre(attaquant, "s'est soigné et récupère 100% de sa vie !");
      } else {
          attaquant.attaquer(defenseur);
          afficherMonstre(attaquant, "a attaqué et infligé " + attaquant.getForce() + " dégâts.");
      }
  }
  private static void afficherMonstre(Entite attaquant, String message){
      try {
          String mon_sprite = Files.readString(Paths.get(attaquant.getSprite()));
          System.out.println(mon_sprite);
          System.out.println(attaquant.getNom() + " " + message);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  private static void afficherSalle() {
    try {
      String salle = OutilsDev.chemineEnChaineDeCharacteres("res/maps/etage" + numero_etage + "/salles/" + x + ";" + y + ".txt");
      System.out.println(salle);
      System.out.println(
        "+======================================================+"
      );
      System.out.println(
        "|         étage n'" +
        numero_etage +
        "   x :" +
        x +
        " ; y : " +
        y +
        "                     |"
      );
    } catch (Exception e) {
      e.getStackTrace();
    }
  }

  private static void creationListeSalles() {
    for (int i = 1; i < NB_ETAGE + 1; i++) {
      LISTE_ETAGE.add(new Etage(i));
    }

    for (Etage temp_etage : LISTE_ETAGE) {
      ArrayList<String[]> salles = OutilsDev.csvRead(
        "res/maps/etage" + temp_etage.getNumero() + "/csv/salles.csv"
      );
      ArrayList<Salle> list_temp = new ArrayList<>();
      Salle temp;
      for (String[] strings : salles) {
        boolean contientMonstre = Boolean.parseBoolean(strings[0]);
        boolean contientCoffre = Boolean.parseBoolean(strings[2]);
        boolean estBoss = Boolean.parseBoolean(strings[1]);

        // Conversion de la chaîne des portes en tableau de booléens
        String[] portesStr = strings[3].split(",");
        boolean[] portes = new boolean[portesStr.length];

        for (int i = 0; i < portesStr.length; i++) {
          portes[i] = Boolean.parseBoolean(portesStr[i]);
        }

        // Récupération des positions X et Y
        int positionX = Integer.parseInt(strings[4]);
        int positionY = Integer.parseInt(strings[5]);

        temp =
          new Salle(
            contientCoffre,
            contientMonstre,
            estBoss,
            portes,
            positionX,
            positionY
          );
        list_temp.add(temp);
      }
      for (int x = 0; x < 3; x++) {
        LISTE_ETAGE
          .get(temp_etage.getNumero() - 1)
          .getSalles()
          .add(new ArrayList<>());
        for (int y = 0; y < 4; y++) {
          LISTE_ETAGE
            .get(temp_etage.getNumero() - 1)
            .getSalles()
            .get(x)
            .add(list_temp.get(0));
          list_temp.remove(0);
        }
      }
    }
  }
}
