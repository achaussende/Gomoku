package GomoKu.PlateauJeu2D;

/**
 * Class Abstraite définissant un Jeu de Plateau 2D
 * @author Antoine
 */
public abstract class JeuDePlateau2D {
    /**
     * Tableau de Joueurs
     */
    private Joueur[] joueurs;
    /**
     * Joueur Courant
     */
    private Joueur joueurCourant;
    /**
     * Plateau de Jeu
     */
    private Plateau plateau;

    /**
     * Getter de joueurCourant
     * @return joueurCourant
     */
    public Joueur getJoueurCourant() {
        return joueurCourant;
    }
    /**
     * Getter de Plateau
     * @return plateau
     */
    public Plateau getPlateau() {
        return plateau;
    }
    
    /**
     * Setter du Plateau
     * @param plateau 
     */
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
    /**
     * Setter d'un ieme joueur dans le tableau de Joueur
     * @param ordre index dans le tableau de Joueurs
     * @param joueur un Joueur
     * @throws ExceptionPlateauJeu2D Exception si le joueur est setté en dehors du tableau de Joueurs
     */
    public void setJoueur(int ordre, Joueur joueur) throws ExceptionPlateauJeu2D {
        if (ordre - 1 < 0 || ordre - 1 > joueurs.length) {
            throw new ExceptionPlateauJeu2D("Indice de Joueur en dehors du tableau");
        } else {
            this.joueurs[ordre - 1] = joueur;
        }
    }
    /**
     * Setter du Tableau de Joueurs
     * @param joueurs un tableau de Joueurs
     */
    public void setJoueurs(Joueur[] joueurs) {
        this.joueurs = joueurs;
    }

    /**
     * Donne le joueur suivant au joueur courant. Si aucun joueur n'a joué
     * encore, c'est le premier joueur dans le tableau de joueurs qui devient le
     * joueur courant.
     */
    public void joueurSuivant() {
        // Si personne n'a encore joué
        if (plateau.getDernierId() == 0) {
            joueurCourant = joueurs[0];
        } else {
            for (int i = 0; i < joueurs.length; i++) {
                //Si le joueur dans le tableau de joueur est le dernier à avoir joué
                if (joueurs[i].getId() == plateau.getDernierId()) {
                    //Si ce joueur est le dernier dans le tableau de joueurs ...
                    if (i + 1 >= joueurs.length) {
                        //... alors c'est au tour du premier
                        joueurCourant = joueurs[0];
                        return;
                    } else {
                        // ... sinon c'est le joueur suivant
                        joueurCourant = joueurs[i + 1];
                        return;
                    }
                }
            }
        }

    }

    /**
     * Vérifie si la partie dans l'était où elle se trouve, est terminée
     *
     * @return True si terminée, false sinon
     */
    public abstract boolean partieTerminee();

    /**
     * Vérifie si le coup spécifié est valide
     *
     * @param c
     * @return True si valide, false sinon
     */
    public abstract boolean coupValide(Coup c);

    /**
     * Lance une partie avec les paramètres courants
     *
     * @param affichGrille True pour afficher la grille lorsqu'on joue la partie. False sinon
     * (L'intérêt est pour afficher ou non lors des simulations de l'IA Monte Carlo
     * @return Joueur vainqueur
     */
    public abstract Joueur jouerPartie(boolean affichGrille);
}
