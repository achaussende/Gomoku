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
import GomoKu.PlateauJeu2D.Plateau;
import GomoKu.PlateauJeu2D.Position;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine
 */
public class JeuDeGomoku extends JeuDePlateau2D{

    public JeuDeGomoku() {
    }

    @Override
    public boolean partieTerminee() {
       PlateauGomoku etatJeu = (PlateauGomoku)this.getPlateau();
       Coup lastCoup = etatJeu.getHistorique().getLast();
       Position posDernierCoup = lastCoup.getPos();
        try {
            return (etatJeu.checkColonneId(posDernierCoup, lastCoup.getId(), 5) 
                    || etatJeu.checkLigneId(posDernierCoup, lastCoup.getId(), 5));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println("Erreur dans la vérification de la fin de partie : partieTerminee().");
        }
        return false;
        
    }

    @Override
    public Joueur jouerPartie() {
        Joueur joueurCourant=null;
        while(!partieTerminee()){
            joueurCourant=this.getJoueurSuivant();
            Coup c;
            do{
                c=joueurCourant.genererCoup(this.getPlateau());
                this.getPlateau().jouer(c);
            }while(!coupValide(c));
        }
        return joueurCourant;
    }

    @Override
    public boolean coupValide(GomoKu.PlateauJeu2D.Coup c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



        
}
