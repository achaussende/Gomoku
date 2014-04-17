package GomoKu.PlateauJeu2D;

/**
 * Position dans une Grille
 *
 * @author Adrien CHAUSSENDE
 */
public class Position {

    /**
     * Indice de ligne
     */
    private int x;
    /**
     * Indice de colonne
     */
    private int y;

    /**
     * Constructeur de la Position
     *
     * @param x indice de ligne
     * @param y indice de colonne
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur Vide d'une Position
     */
    public Position() {
    }

    /**
     * Re-définition de la méthode toString
     *
     * @return Chaine de caractère définissant une Position
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(x);
        sb.append(",");
        sb.append(y);
        sb.append(")");

        return sb.toString();
    }

    /**
     * Getter de x
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter de x
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter de y
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter de y
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
