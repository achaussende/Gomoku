/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.JeuDePlateau2D;
import GomoKu.PlateauJeu2D.JeuDePlateauFactory;
import GomoKu.PlateauJeu2D.JoueurAleatoire;
import GomoKu.PlateauJeu2D.JoueurHumain;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class JeuDeGomokuFactory implements JeuDePlateauFactory{
     @Override
    public JeuDePlateau2D CreerPartieHumainVSHumain(ArrayList<Coup> situation) {
        JeuDePlateau2D jeu=new JeuDeGomoku();
        try {
            jeu.setPlateau(new PlateauGomoku(9,9)); 
            jeu.setJoueur(1,new JoueurHumain(1));
            jeu.setJoueur(2,new JoueurHumain(2));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println(ex.getMess_err());
        }
        for(Coup c:situation){
            jeu.getPlateau().jouer(c);
        }
        return jeu;
    }

    @Override
    public JeuDePlateau2D CreerPartieHumainVSAleatoire(ArrayList<Coup> situation) {
        JeuDePlateau2D jeu=new JeuDeGomoku();
        try {
            jeu.setPlateau(new PlateauGomoku(9,9)); 
            jeu.setJoueur(1,new JoueurHumain(1));
            jeu.setJoueur(2,new JoueurAleatoire(2));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println(ex.getMess_err());
        }
        for(Coup c:situation){
            jeu.getPlateau().jouer(c);
        }
        return jeu;
    }

    @Override
    public JeuDePlateau2D CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation) {
        JeuDePlateau2D jeu=new JeuDeGomoku();
        try {
            jeu.setPlateau(new PlateauGomoku(9,9)); 
            jeu.setJoueur(1,new JoueurAleatoire(1));
            jeu.setJoueur(2,new JoueurAleatoire(2));
        } catch (ExceptionPlateauJeu2D ex) {
            System.out.println(ex.getMess_err());
        }
        for(Coup c:situation){
            jeu.getPlateau().jouer(c);
        }
        return jeu;
    }
}
