package main.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import main.java.carte.Salle;
import main.java.entite.Joueur;

public class Sauvegarde {
    public static void sJoueur(Joueur j){
        try (FileOutputStream fileOut = new FileOutputStream("res/sauvegarde/joueur.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(j);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void sSalle(Salle s){
        try (FileOutputStream fileOut = new FileOutputStream("res/sauvegarde/salle.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(s);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
