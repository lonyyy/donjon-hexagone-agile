package test.main.java.carte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.carte.Coffre;
import main.java.enums.Effet;
import main.java.enums.Rarete;
import main.java.equipement.Equipement;
import main.java.equipement.TypeEquipement;

public class CoffreTest {
    
    @Test
    public void CoffreTest(){
        Coffre coffre = new Coffre();
        coffre.init("res/maps/etage1/csv/equipement.csv");
        Equipement dague = new Equipement("Dague rouillée", 3, Effet.AUCUN, Rarete.COMMUN, TypeEquipement.DAGUE, 1);
        Equipement bouclier = new Equipement("Bouclier de merde", 0, Effet.AUCUN, Rarete.COMMUN, TypeEquipement.BOUCLIER, 1);
        Equipement arc = new Equipement("Arc sans nom", 2, Effet.AUCUN, Rarete.COMMUN, TypeEquipement.ARC, 1);
        Equipement baton = new Equipement("Baton pas cher", 1, Effet.AUCUN, Rarete.COMMUN, TypeEquipement.BATON, 1);
        Equipement resul = coffre.ButinEquipement();
        if(resul.equals(dague) || resul.equals(bouclier) || resul.equals(arc) || resul.equals(baton)){
            assertEquals(1, 1);
        }else{
            assertEquals(1, 2);
        }
    }

}
