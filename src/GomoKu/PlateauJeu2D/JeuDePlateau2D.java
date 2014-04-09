
package GomoKu.PlateauJeu2D;

import java.util.ArrayList;


/**
 *
 * @author Antoine
 */
public abstract class JeuDePlateau2D {

    private Joueur[] joueurs;
    private Joueur joueurSuivant;
    private Plateau plateau;

    public Plateau getPlateau() {
        return plateau;
    }

    public Joueur getJoueurSuivant() {
        if(joueurSuivant==null){
            return joueurs[0];
        }else{
            for(int i=0;i<joueurs.length;i++){
                if(joueurs[i].equals(joueurSuivant)){
                    if(i==joueurs.length-1){
                        return joueurs[0];
                    }else{
                        return joueurs[i];
                    }
                }
            }
        }
        return null;
    }
    
    public ArrayList<Coup> getSituation() {
        ArrayList<Coup> histo = new ArrayList<>(this.getPlateau().getHistorique().clone());
        return histo;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void setJoueur(int ordre, Joueur joueur) throws ExceptionPlateauJeu2D {
        if (ordre - 1 < 0 || ordre - 1 > joueurs.length) {
            throw new ExceptionPlateauJeu2D("Indice de Joueur en dehors du tableau");
        } else {
            this.joueurs[ordre - 1] = joueur;
        }
    }
    
    public abstract boolean partieTerminee();
    public abstract boolean coupValide(Coup c);
    public abstract Joueur jouerPartie();
}
