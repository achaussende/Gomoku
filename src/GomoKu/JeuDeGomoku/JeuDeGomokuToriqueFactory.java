package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.JeuDePlateau2D;
import GomoKu.PlateauJeu2D.JeuDePlateauFactory;
import GomoKu.PlateauJeu2D.JoueurAleatoire;
import GomoKu.PlateauJeu2D.JoueurHumain;
import GomoKu.PlateauJeu2D.JoueurMonteCarlo;
import java.util.ArrayList;

/**
 * Factory pour créer des parties entre adversaires différents sur un Gomoku à
 * plateau torique
 *
 * @author Adrien CHAUSSENDE
 */
public class JeuDeGomokuToriqueFactory implements JeuDePlateauFactory {

    @Override
    public JeuDePlateau2D CreerPartieHumainVSHumain(ArrayList<Coup> situation) {
        JeuDePlateau2D jeu = new JeuDeGomoku();
        try {
            jeu.setPlateau(new PlateauGomokuTorique(9, 9));
            jeu.setJoueur(1, new JoueurHumain(1));
            jeu.setJoueur(2, new JoueurHumain(2));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println(ex.getMess_err());
        }
        for (Coup c : situation) {
            jeu.getPlateau().jouer(c);
        }

        jeu.joueurSuivant();
        return jeu;
    }

    @Override
    public JeuDePlateau2D CreerPartieHumainVSAleatoire(ArrayList<Coup> situation) {
        JeuDePlateau2D jeu = new JeuDeGomoku();
        try {
            jeu.setPlateau(new PlateauGomokuTorique(9, 9));
            jeu.setJoueur(1, new JoueurHumain(1));
            jeu.setJoueur(2, new JoueurAleatoire(2));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println(ex.getMess_err());
        }
        for (Coup c : situation) {
            jeu.getPlateau().jouer(c);
        }
        jeu.joueurSuivant();
        return jeu;
    }

    @Override
    public JeuDePlateau2D CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation) {
        JeuDePlateau2D jeu = new JeuDeGomoku();
        try {
            jeu.setPlateau(new PlateauGomokuTorique(9, 9));
            jeu.setJoueur(1, new JoueurAleatoire(1));
            jeu.setJoueur(2, new JoueurAleatoire(2));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println(ex.getMess_err());
        }
        if (situation != null) {
            for (Coup c : situation) {
                jeu.getPlateau().jouer(c);
            }
        }

        jeu.joueurSuivant();
        return jeu;
    }

    @Override
    public JeuDePlateau2D CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation) {
        JeuDePlateau2D jeu = new JeuDeGomoku();
        JeuDeGomokuToriqueFactory fact = new JeuDeGomokuToriqueFactory();
        try {
            jeu.setPlateau(new PlateauGomokuTorique(9, 9));
            jeu.setJoueur(1, new JoueurHumain(1));
            jeu.setJoueur(2, new JoueurMonteCarlo(2, 10000, fact));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println(ex.getMess_err());
        }
        if (situation != null) {
            for (Coup c : situation) {
                jeu.getPlateau().jouer(c);
            }
        }
        jeu.joueurSuivant();
        return jeu;
    }
}
