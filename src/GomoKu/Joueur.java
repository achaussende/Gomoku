
package GomoKu;

/**
 *
 * @author Antoine CARON
 */
public abstract class Joueur {
    private int id;

    public int getId() {
        return id;
    }

    public Joueur(int id) {
        this.id = id;
    }
    
    public abstract Coup genererCoup(Plateau etatJeu);    
}
