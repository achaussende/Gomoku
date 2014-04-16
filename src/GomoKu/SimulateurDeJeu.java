package GomoKu;

import GomoKu.JeuDeGomoku.JeuDeGomoku;
import GomoKu.JeuDeGomoku.JeuDeGomokuFactory;
import GomoKu.JeuDeGomoku.PlateauGomoku;
import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.JeuDePlateau2D;
import GomoKu.PlateauJeu2D.Joueur;
import GomoKu.PlateauJeu2D.JoueurAleatoire;
import GomoKu.PlateauJeu2D.Plateau;
import GomoKu.PlateauJeu2D.Position;

/**
 *
 * @author Adrien CHAUSSENDE
 */
public class SimulateurDeJeu {

    public static void main(String[] args) throws ExceptionPlateauJeu2D {
        /*
         //Situation de test
         int[][] ex_situation = {
         {0, 0, 2, 0, 0, 0, 0, 0, 0},
         {0, 0, 2, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 2, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 1, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 2, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0}
         };
         */

        // Situation de jeu Aléatoire VS Aléatoire
        JeuDeGomokuFactory launcher = new JeuDeGomokuFactory();
        JeuDePlateau2D jeu = launcher.CreerPartieAleatoireVSAleatoire(null);
        System.out.println(jeu.getPlateau().toString(false));
        Joueur vainqueur = jeu.jouerPartie();
        System.out.println(jeu.getPlateau().toString(false));
        System.out.println("Le joueur vainqueur est le joueur : " + vainqueur.getId());

        /*
         //Situation : on joue un coup
         JeuDePlateau2D jeu = new JeuDeGomoku();
         jeu.setPlateau(new PlateauGomoku(9, 9));
         jeu.setJoueur(1, new JoueurAleatoire(1));
         jeu.setJoueur(2, new JoueurAleatoire(2));
         jeu.joueurSuivant();
         Coup c = jeu.getJoueurCourant().genererCoup(jeu.getPlateau());
         jeu.getPlateau().jouer(c);
         c = jeu.getJoueurCourant().genererCoup(jeu.getPlateau());
         jeu.getPlateau().jouer(c);
         c = jeu.getJoueurCourant().genererCoup(jeu.getPlateau());
         jeu.getPlateau().jouer(c);
         c = jeu.getJoueurCourant().genererCoup(jeu.getPlateau());
         jeu.getPlateau().jouer(c);
         System.out.println(jeu.getPlateau().toString(false));*/
    }
}
