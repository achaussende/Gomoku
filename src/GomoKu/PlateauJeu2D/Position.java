package GomoKu.PlateauJeu2D;

/**
 * un Position dans un Grille
 * @author Adrien CHAUSSENDE
 */
public class Position {
    /**
     * position sur l'axe x
     */
    private int x;
    /**
     * position sur l'axe y
     */
    private int y;
    /**
     * Constrcteur de la Position
     * @param x position sur l'axe x
     * @param y position sur l'axe y
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
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * Setter de x
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Getter de y
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * Setter de y
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
}
