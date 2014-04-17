package GomoKu.PlateauJeu2D;

/**
 * Objet permettant à l'IA de MonteCarlo de faire son choix
 *
 * @author Antoine CARON
 */
public class Noeud {

    /**
     * Nombre de victoires réalisées durant les simulations
     */
    private int nbVictoire;
    /**
     * Nombre de simulations à effectuer
     */
    private int nbSimulation;
    /**
     * Coup à jouer
     */
    private Coup coup;

    /**
     * Getter du coup à jouer
     *
     * @return
     */
    public Coup getCoup() {
        return coup;
    }

    /**
     * Constructeur du noeud en passant en paramètre un coup
     *
     * @param coup
     */
    public Noeud(Coup coup) {
        this.coup = coup;
    }

    /**
     * Augmente le nombre de victoires de 1
     */
    public void ajouterVictoire() {
        ++nbVictoire;
    }

    /**
     * Diminue le nombre de victoires de 1
     */
    public void ajouterDefaite() {
        --nbVictoire;
    }

    /**
     * Retourne le pourcentage de victoires gagnantes par rapport au nombre de
     * simulations effectuées
     *
     * @return Pourcentage de victoires gagnantes
     */
    public double getMoyenne() {
        return (double) 100 * (double) nbVictoire / (double) nbSimulation;
    }

}
