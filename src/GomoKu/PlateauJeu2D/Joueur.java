package GomoKu.PlateauJeu2D;

/**
 * Objet Abstrait d'un Joueur
 *
 * @author Antoine CARON
 */
public abstract class Joueur {

    /**
     * Identifiant du joueur
     */
    private int id;

    /**
     * Getter de l'ID
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de l'ID
     *
     * @param id
     */
    public Joueur(int id) {
        this.id = id;
    }

    /**
     * Fonction Abstraite de génération de coup pour un Joueur
     *
     * @param etatJeu
     * @return
     */
    public abstract Coup genererCoup(Plateau etatJeu);
}
