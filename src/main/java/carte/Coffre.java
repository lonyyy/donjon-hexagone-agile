package main.java.carte;

import java.util.ArrayList;
import java.util.Random;

import main.java.OutilsDev;
import main.java.consommable.Bandage;
import main.java.consommable.Consommable;
import main.java.consommable.EssenceDeForce;
import main.java.consommable.EssenceDeMana;
import main.java.consommable.EssenceDeVie;
import main.java.consommable.EssenceDeVitesse;
import main.java.enums.Effet;
import main.java.enums.Rarete;
import main.java.equipement.Equipement;
import main.java.equipement.TypeEquipement;

public class Coffre {
    private final Random RAND = new Random();
    private ArrayList<Equipement> equipem;
    private ArrayList<Consommable> consom;

    public Coffre(){
        this.equipem = new ArrayList<>();
        this.consom = new ArrayList<>();
    }

    public void init(String filename){
        this.consom.add(new EssenceDeForce(Rarete.RARE, "Âme de Minotaure", Effet.BONUS_FORCE, RAND.nextInt(3,  5)));
        this.consom.add(new EssenceDeVie(Rarete.PEU_COMMUN, "Âme de Vampire", Effet.BONUS_VIE, 1));
        this.consom.add(new EssenceDeVitesse(Rarete.EPIQUE, "Âme de Guépard", Effet.BONUS_VITESSE, 2));
        this.consom.add(new EssenceDeMana(Rarete.EPIQUE, "Âme de Dragon", Effet.BONUS_MANA, 6));
        this.consom.add(new Bandage(Rarete.PEU_COMMUN, "Bandage", Effet.REGENERATION, 3));

        ArrayList<Equipement> e = new ArrayList<>();
        ArrayList<String[]> csv = OutilsDev.csvRead(filename);
        for (String[] elt : csv) {
            e.add(new Equipement(elt[0], Integer.parseInt(elt[1]), Effet.valueOf(elt[2].toUpperCase()), elt[3], TypeEquipement.valueOf(elt[4].toUpperCase()), Integer.parseInt(elt[5])));
        }
        this.equipem = e;
    }

    /**Renvoie un equipement aléatoire parmis un CSV
     * @return
     */
    public Equipement ButinEquipement(){
        return OutilsDev.randomList(this.equipem);
    }

    /**Renvoie un consommable aléatoire parmet une liste
     * @return
     */
    public Consommable ButinConsom(){
        return OutilsDev.randomList(this.consom);
    }

    public ArrayList<Equipement> getEquipem() {
        return equipem;
    }

    public void setEquipem(ArrayList<Equipement> equipem) {
        this.equipem = equipem;
    }

    public ArrayList<Consommable> getConsom() {
        return consom;
    }

    public void setConsom(ArrayList<Consommable> consom) {
        this.consom = consom;
    }

    
}