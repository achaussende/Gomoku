package GomoKu.PlateauJeu2D;

import java.util.ArrayList;

/**
 * IA dont la décision est prise suivant une approche de Monte Carlo
 * @author Adrien
 */
public class JoueurMonteCarlo extends Joueur {

    private JeuDePlateauFactory jeuFactory;
    private int nbSimulations;

    public JoueurMonteCarlo(int id) {
        super(id);
    }

    public JoueurMonteCarlo(int id, int nbSimulations, JeuDePlateauFactory jeuFactory) {
        super(id);
        this.jeuFactory = jeuFactory;
        this.nbSimulations = nbSimulations;
    }
    /**
     * Effectue des simulations suivant les approches de Monte Carlo,
     * pour chaque coup possibles sur l'etat du jeu actuel
     * afin de renvoyer le meilleur coup à jouer
     * @param etatJeu : Plateau actuel de jeu sur lequel 
     * les simulations et le coup à jouer seront générés
     * @return Meilleur coup à jouer
     */
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.etatId(0);
        for (Position p : positionsPossibles) {
            Coup cCourant = new Coup(this.getId(), p);
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            ArrayList<Coup> sit = etatJeu.getSituation();
            for (int i = 0; i < nbSimulations; i++) {
                Joueur gagnant = jeuFactory.CreerPartieAleatoireVSAleatoire(sit).jouerPartie();
                if (gagnant.getId() == this.getId()) {
                    nCourant.ajouterVictoire();
                } else {
                    nCourant.ajouterDefaite();
                }
            }
            if (meilleurCoup == null || meilleurCoup.getMoyenne() < nCourant.getMoyenne()) {
                meilleurCoup = nCourant;
            }
            etatJeu.annuler();
        }
        return meilleurCoup.getCoup();
    }

}
