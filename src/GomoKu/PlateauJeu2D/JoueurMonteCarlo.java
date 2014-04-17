package GomoKu.PlateauJeu2D;

import java.util.ArrayList;

/**
 * IA dont la décision est prise suivant une approche de Monte Carlo
 *
 * @author Adrien CHAUSSENDE
 */
public class JoueurMonteCarlo extends Joueur {

    /**
     * Factory pour que l'IA puisse réaliser ses simulations
     */
    private JeuDePlateauFactory jeuFactory;
    /**
     * Nombre de simulations à effectuer
     */
    private int nbSimulations;

    /**
     * Constructeur de JoueurMonteCarlo en passant son identifiant durant cette
     * partie
     *
     * @param id Identifiant
     */
    public JoueurMonteCarlo(int id) {
        super(id);
    }

    /**
     * Constructeur de JoueurMontecarlo en passant son identifiant, le nombre de
     * simulations à effectuer et la factory pour ses simulations
     *
     * @param id Identifiant
     * @param nbSimulations Nombre de simulations
     * @param jeuFactory Factory de jeu de plateau pour le simulations de l'IA
     */
    public JoueurMonteCarlo(int id, int nbSimulations, JeuDePlateauFactory jeuFactory) {
        super(id);
        this.jeuFactory = jeuFactory;
        this.nbSimulations = nbSimulations;
    }

    /**
     * Effectue des simulations suivant les approches de Monte Carlo, pour
     * chaque coup possibles sur l'etat du jeu actuel afin de renvoyer le
     * meilleur coup à jouer
     *
     * @param etatJeu : Plateau actuel de jeu sur lequel les simulations et le
     * coup à jouer seront générés
     * @return Meilleur coup à jouer
     */
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.getPositionsParId(0);
        System.out.println("MonteCarlo : C'est à mon tour, laissez moi réfléchir.");
        for (Position p : positionsPossibles) {
            Coup cCourant = new Coup(this.getId(), p);
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            ArrayList<Coup> sit = etatJeu.getSituation();
            for (int i = 0; i < nbSimulations; i++) {
                Joueur gagnant = jeuFactory.CreerPartieAleatoireVSAleatoire(sit).jouerPartie(false);
                if (gagnant != null) {
                    if (gagnant.getId() == this.getId()) {
                        nCourant.ajouterVictoire();
                    } else {
                        nCourant.ajouterDefaite();
                    }
                }
            }
            if (meilleurCoup == null || meilleurCoup.getMoyenne() < nCourant.getMoyenne()) {
                meilleurCoup = nCourant;
            }
            etatJeu.annuler();
        }
        System.out.println("J'ai trouvé !");
        return meilleurCoup.getCoup();
    }

}
