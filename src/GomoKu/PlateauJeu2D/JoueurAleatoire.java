package GomoKu.PlateauJeu2D;

import java.util.ArrayList;

/**
 * Objet de joueur aléatoire.
 *
 * @author Adrien CHAUSSENDE
 */
public class JoueurAleatoire extends Joueur {

    /**
     * Constructeur d'un joueur aléatoire en lui passant un id
     *
     * @param id identifiant à lui donner
     */
    public JoueurAleatoire(int id) {
        super(id);
    }

    /**
     * Permet de générer le coup que désire jouer le joueur aléatoire. Ce coup
     * est un coup choisit aléatoirement parmi la liste de coups disponibles
     *
     * @param etatJeu etat actuel du plateau de jeu
     * @return Coup à jouer
     */
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
