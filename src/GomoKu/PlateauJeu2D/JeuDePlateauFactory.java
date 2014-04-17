package GomoKu.PlateauJeu2D;

import java.util.ArrayList;

/**
 * Interface de Factory d'un jeu de Plateau
 *
 * @author Adrien CHAUSSENDE
 */
public interface JeuDePlateauFactory {

    /**
     * Crée un Partie Humain Contre Humain
     *
     * @param situation tableau de coups
     * @return JeuDePlateau2D dont tous les coups passés en paramètre ont été
     * joué
     */
    public JeuDePlateau2D CreerPartieHumainVSHumain(ArrayList<Coup> situation);

    /**
     * Crée un Partie Humain Contre un Joueur Aléatoire
     *
     * @param situation tableau de coups
     * @return JeuDePlateau2D dont tous les coups passés en paramètre ont été
     * joué
     */
    public JeuDePlateau2D CreerPartieHumainVSAleatoire(ArrayList<Coup> situation);

    /**
     * Crée un Partie un Joueur Aléatoire Contre un Joueur Aléatoire
     *
     * @param situation tableau de coups
     * @return JeuDePlateau2D dont tous les coups passés en paramètre ont été
     * joué
     */
    public JeuDePlateau2D CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation);

    /**
     * Crée un Partie un Joueur Humain Contre un Joueur IA Monte-Carlo
     *
     * @param situation tableau de coups
     * @return JeuDePlateau2D dont tous les coups passés en paramètre ont été
     * joué
     */
    public JeuDePlateau2D CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation);
}
