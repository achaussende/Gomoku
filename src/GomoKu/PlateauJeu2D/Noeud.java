
package GomoKu.PlateauJeu2D;

/**
 *
 * @author Antoine
 */
public class Noeud {
    private int nbVictoire;
    private int nbSimultation;
    private Coup coup;

    public Coup getCoup() {
        return coup;
    }

    public Noeud(Coup coup) {
        this.coup = coup;
    }
    public void ajouterVictoire(){
        ++nbVictoire;
    }
    public void ajouterDefaite(){
        --nbVictoire;
    }
    
    
}
