package main.java.entite;

public class Monstre extends Entite{

    public Monstre(String nom, int force, int vie, int vitesse, int mana, String sprite){
        super(nom, force, vie, vitesse, mana, sprite);
    }
    
    @override
    public String getSprite() {
        return "res/sprites/monstres/" + sprite + ".txt";
      }
}
