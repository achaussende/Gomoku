/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.Joueur;
import GomoKu.PlateauJeu2D.JeuDePlateau2D;
import GomoKu.PlateauJeu2D.Plateau;

/**
 *
 * @author Antoine
 */
public class JeuDeGomoku extends JeuDePlateau2D{

    public JeuDeGomoku() {
    }

    @Override
    public boolean partieTerminee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
