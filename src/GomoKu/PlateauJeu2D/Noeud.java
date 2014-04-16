package GomoKu.PlateauJeu2D;

/**
 *
 * @author Antoine CARON
 */
public class Noeud {

    private int nbVictoire;
    private int nbSimulation;
    private Coup coup;

    public Coup getCoup() {
        return coup;
    }

    public Noeud(Coup coup) {
        this.coup = coup;
    }

    public void ajouterVictoire() {
        ++nbVictoire;
    }

    public void ajouterDefaite() {
        --nbVictoire;
    }

    /**
     *
     * @return Retourne le pourcentage de victoires gagnantes par rapport au
     * nombre de simulations effectuées
     */
    public double getMoyenne() {
        return (double) 100 * (double) nbVictoire / (double) nbSimulation;
    }

}
