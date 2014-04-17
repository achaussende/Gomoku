package GomoKu.PlateauJeu2D;

import GomoKu.PlateauJeu2D.Position;

/**
 *
 * @author Adrien CHAUSSENDE Objet définissant un coup à jouer par un Joueur
 */
public class Coup {

    /**
     * identifiant du Joueur du coup
     */
    private int id;
    /**
     * position du coup dans la grille
     */
    private Position pos;

    /**
     * Constructeur Vide
     */
    public Coup() {
    }

    /**
     * Constructeur d'un Coup
     *
     * @param id identifiant du joueur qui joue le coup
     * @param pos position du coup dans la grille
     */
    public Coup(int id, Position pos) {
        this.id = id;
        this.pos = pos;
    }

    /**
     * Getter de l'id
     *
     * @return id identifiant du joueur du coup
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de l'id
     *
     * @param id identifiant du joueur du coup
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de la position du coup dans la grille
     *
     * @return pos position du coup dans la grille
     */
    public Position getPos() {
        return pos;
    }

    /**
     * Setter de la position du coup dans la grille
     *
     * @param pos position du coup dans la grille
     */
    public void setPos(Position pos) {
        this.pos = pos;
    }

    /**
     * Affichage de l'id et de la position du coup
     *
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Le coup d'id ");
        sb.append(id);
        sb.append(" a été joué à la position de coordonnées : ");
        sb.append(pos.toString());
        return sb.toString();
    }
}
