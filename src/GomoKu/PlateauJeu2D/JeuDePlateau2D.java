
package GomoKu.PlateauJeu2D;

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
        return joueurSuivant;
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
