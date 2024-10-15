package test.main.java.entite;

import static org.junit.Assert.assertEquals;

import main.java.classes.Guerrier;
import main.java.entite.Entite;
import main.java.entite.Joueur;
import org.junit.Before;
import org.junit.Test;
public class EntiteTest {

  Joueur joueur;

  @Before
  public void init() {
    joueur =
      new Joueur("joueur", 10, 10, 10, 10, "sprite", new Guerrier(), null);
  }

  @Test
  public void testInventaire() {
    assertEquals(0, joueur.getInventaire().size());

    joueur.stockerDansLinventaire(null);

    assertEquals(1, joueur.getInventaire().size());

    joueur.enleverDeLinventaire(null);

    assertEquals(0, joueur.getInventaire().size());

    joueur.stockerDansLinventaire(null);

    joueur.clearInventaire();

    assertEquals(0, joueur.getInventaire().size());
  }

  @Test
  public void testAttaque() {
    Entite entite = new Entite("entite", 5, 5, 5, 5, "sprite") {
      @Override
      public void attaquer(Entite cible) {
        cible.setVie(cible.getVie() - this.getForce());
      }
    };

    assertEquals(10, joueur.getVie());

    entite.attaquer(joueur);

    assertEquals(5, joueur.getVie());
  }
}
