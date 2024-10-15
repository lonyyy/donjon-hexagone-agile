package main.java.consommable;
import main.java.enums.Effet;
import main.java.enums.Rarete;

public abstract class Consommable{
    private Effet effet;
    private int bonus;
    private Rarete rarete;
    private String nom;

    /** Ce constructeur creer un consommable a partir d'une enum rarete et d'une String nom, enum effet
     * @param rarete
     * @param nom
     * @param effet
     */
    public Consommable(Rarete rarete, String nom, Effet effet, int bonus){
        this.rarete = rarete;
        this.nom = nom;
        this.effet = effet;
        this.bonus = bonus;
    }

    /** Ce constructeur permet de creer un consommable a partir de trois string, un pour la rareté, un pour le nom et un autre pour l'effet. Si la rareté associé ne correspond pas a une rareté existante, le consommable regenere de la vie
     * @param rarete
     * @param nom
     * @param effet
     */
    public Consommable(String rarete, String nom, String effet, int bonus){
        this.nom = nom;
        int idx = 0;
        while(idx<Rarete.values().length && !rarete.equals(this.effet.toString())){
            if(Rarete.values()[idx].toString().equals(rarete)){
                this.effet = Effet.valueOf(rarete);
            }else{
                this.effet = Effet.values()[0];
            }
        }
        this.bonus = bonus;
    }

    public Effet getEffet() {
        return effet;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public String getNom() {
        return nom;
    }

    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
