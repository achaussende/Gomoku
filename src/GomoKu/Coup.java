package GomoKu;

import GomoKu.Position;

/**
 *
 * @author Adrien CHAUSSENDE p1105501
 */
public class Coup {

    private int id;
    private Position pos;

    public Coup() {
    }

    public Coup(int id, Position pos) {
        this.id = id;
        this.pos = pos;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Position getPos() {
        return pos;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }
    
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
