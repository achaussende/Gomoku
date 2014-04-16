package GomoKu.PlateauJeu2D;

import java.util.ArrayList;

/**
 *
 * @author Adrien CHAUSSENDE
 */
public class JoueurAleatoire extends Joueur {

    public JoueurAleatoire(int id) {
        super(id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {

        ArrayList<Position> posPossibles = etatJeu.getPositionsParId(0);
        if (posPossibles.isEmpty()) {
            return null;
        }
        Position pos = posPossibles.get(Utilitaire.monRandom(0, posPossibles.size() - 1));
        return new Coup(this.getId(), pos);
    }

}
