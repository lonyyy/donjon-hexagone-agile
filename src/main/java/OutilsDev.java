package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;


public class OutilsDev {
    static final String DELIMITER = ";";
    private final static Random RAND = new Random();

    
    /**Lis un csv et fais une List de tableau de chaine avec
     * @param filename
     * @return
     */
    public static ArrayList<String[]> csvRead(String filename) {
        ArrayList<String[]> arr = new ArrayList<>();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] tokenizedLine;
            
            // Ignore la première ligne
            bufferedReader.readLine();
    
            while ((line = bufferedReader.readLine()) != null) {
                tokenizedLine = line.split(DELIMITER);
                arr.add(tokenizedLine);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier spécifié est introuvable : " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return arr;
    }
    

    public static int entree_entier(Scanner sc ) {
        int nombre = 0;
        boolean saisieValide = false;

        while (!saisieValide) {
            try {
                System.out.print("Veuillez entrer un entier (valide) : ");
                nombre = sc.nextInt();
                saisieValide = true;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Ce n'est pas un entier (valide). Veuillez réessayer.");
                sc.next(); // vide le buffer du scanner

            }
        }

        return nombre;
    }
    /**Renvoie un consommable aléatoire parmet une liste
     * @return 
     */
    public static <T> T randomList(List<T> l){
        return l.get(RAND.nextInt(0, l.size()));
    }

    public static String chemineEnChaineDeCharacteres(String chemin){
        String c = null;
        try{
            c = Files.readString(Paths.get(chemin));
        }catch (IOException e) {
            System.out.println("Le fichier est introuvable");
            e.printStackTrace();
        }
        return c;
    }
}
