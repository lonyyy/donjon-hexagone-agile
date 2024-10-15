package test.main.java.consommable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.classes.Mage;
import main.java.consommable.*;
import main.java.entite.Joueur;
import main.java.enums.Effet;
import main.java.enums.Rarete;

public class ConsommableTest {
    

    @Test
    public void EssenceDeForceTest(){
        EssenceDeForce essenceDeForce = new EssenceDeForce(Rarete.COMMUN, "Ame du Minotaure", Effet.BONUS_FORCE , 3);
        Joueur joueur = new Joueur("Vodah", 10, 20, 5, 15, "joueur.txt", new Mage(), null);
        joueur.setMainDirect(joueur.getClasse().getEquipement());
        essenceDeForce.utiliserEssence(joueur);
        assertEquals(13, joueur.getForce());
    }

    @Test
    public void EssenceDeManaTest(){
        EssenceDeMana essenceDeMana = new EssenceDeMana(Rarete.COMMUN, "Ame de l'Ogre", Effet.BONUS_MANA , 5);
        Joueur joueur = new Joueur("Vodah", 10, 20, 5, 15, "joueur.txt", new Mage(), null);
        joueur.setMainDirect(joueur.getClasse().getEquipement());
        essenceDeMana.utiliserEssence(joueur);
        assertEquals(20, joueur.getMana());
    }

    @Test
    public void EssenceDeVieTest(){
        EssenceDeVie essenceDeVie = new EssenceDeVie(Rarete.COMMUN, "Ame de Plantera", Effet.BONUS_VIE , 7);
        Joueur joueur = new Joueur("Vodah", 10, 20, 5, 15, "joueur.txt", new Mage(), null);
        joueur.setMainDirect(joueur.getClasse().getEquipement());
        essenceDeVie.utiliserEssence(joueur);
        assertEquals(27, joueur.getVie());
    }

    @Test
    public void EssenceDeVitesseTest(){
        EssenceDeVitesse essenceDeVitesse = new EssenceDeVitesse(Rarete.COMMUN, "Ame d'Hermes", Effet.BONUS_VITESSE , 9);
        Joueur joueur = new Joueur("Vodah", 10, 20, 5, 15, "joueur.txt", new Mage(), null);
        joueur.setMainDirect(joueur.getClasse().getEquipement());
        essenceDeVitesse.utiliserEssence(joueur);
        assertEquals(14, joueur.getVitesse());
    }

    @Test
    public void Bandage(){
        Bandage bandage = new Bandage(Rarete.COMMUN, "Bandage", Effet.REGENERATION , 6);
        Joueur joueur = new Joueur("Vodah", 10, 20, 5, 15, "joueur.txt", new Mage(), null);
        joueur.setMainDirect(joueur.getClasse().getEquipement());
        joueur.setVieRestante(10);
        bandage.utiliserBandage(joueur);
        assertEquals(16, joueur.getVieRestante());
        joueur.setVieRestante(15);
        
    }
}
