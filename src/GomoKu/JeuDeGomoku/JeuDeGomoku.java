/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.JeuDePlateau2D;
import GomoKu.PlateauJeu2D.Joueur;
import GomoKu.PlateauJeu2D.Position;
import java.util.NoSuchElementException;

/**
 *
 * @author Antoine
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

        try {
            return (etatJeu.checkColonneId(posDernierCoup, lastCoup.getId(), 5)|| etatJeu.checkLigneId(posDernierCoup, lastCoup.getId(), 5));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println("Erreur dans la vérification de la fin de partie : partieTerminee().");
        }
        return false;

    }

    @Override
    public Joueur jouerPartie() {
        while (!partieTerminee()) {
            this.joueurSuivant();
            Coup c;
            do {
                c = this.getJoueurCourant().genererCoup(this.getPlateau());
            } while (!coupValide(c));
            this.getPlateau().jouer(c);
            System.out.println(this.getPlateau().toString(false));
        }
        return this.getJoueurCourant();
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
