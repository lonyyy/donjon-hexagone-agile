package main.java.carte;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;


public class Etage implements Serializable{
  private static final long serialVersionUID = 1;

  List<List<Salle>> salles;
  int numero;


  public Etage(List<List<Salle>> salles, int numero) {
    this.salles = salles;
    this.numero = numero;
  }
  public Etage(int numero){
    this(new ArrayList<>(),numero);
  }

  public List<List<Salle>> getSalles() {
    return salles;
  }

  public int getNumero() {
    return numero;
  }
}
