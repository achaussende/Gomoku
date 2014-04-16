package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.JeuDePlateau2D;
import GomoKu.PlateauJeu2D.Joueur;
import GomoKu.PlateauJeu2D.Position;
import java.util.NoSuchElementException;

/**
 *
 * @author Antoine CARON
 */
public class JeuDeGomoku extends JeuDePlateau2D {

    public JeuDeGomoku() {
        this.setJoueurs(new Joueur[2]);
    }

    @Override
    public boolean partieTerminee() {
        PlateauGomoku etatJeu = (PlateauGomoku) this.getPlateau();
        Coup lastCoup;
        Position posDernierCoup;
        try {
            lastCoup = etatJeu.getHistorique().getLast();
            posDernierCoup = lastCoup.getPos();
        } catch (NoSuchElementException ex) {
            return false;
        }

        return (etatJeu.checkColonneId(posDernierCoup, lastCoup.getId(), 5)
                || etatJeu.checkLigneId(posDernierCoup, lastCoup.getId(), 5)
                || this.getPlateau().isFull());
    }

    @Override
    public Joueur jouerPartie(boolean affichGrille) {
        while (!partieTerminee()) {
            this.joueurSuivant();
            Coup c;
            do {
                c = this.getJoueurCourant().genererCoup(this.getPlateau());
            } while (!coupValide(c));
            this.getPlateau().jouer(c);
            if (affichGrille) {
                System.out.println(this.getPlateau().toString(false));
            }
        }
        if (this.getPlateau().isFull()) {
            return null;
        } else {
            return this.getJoueurCourant();
        }

    }

    @Override
    public boolean coupValide(GomoKu.PlateauJeu2D.Coup c) {
        try {
            return 0 == getPlateau().getIdPosition(c.getPos());
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println("coupValide: accès Hors tableau");
        }
        return false;
    }

}
