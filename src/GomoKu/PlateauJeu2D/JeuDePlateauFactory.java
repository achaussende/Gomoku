package GomoKu.PlateauJeu2D;

import java.util.ArrayList;

/**
 *
 * @author Adrien CHAUSSENDE
 */
public interface JeuDePlateauFactory {

    public JeuDePlateau2D CreerPartieHumainVSHumain(ArrayList<Coup> situation);

    public JeuDePlateau2D CreerPartieHumainVSAleatoire(ArrayList<Coup> situation);

    public JeuDePlateau2D CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation);

    public JeuDePlateau2D CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation);
}
