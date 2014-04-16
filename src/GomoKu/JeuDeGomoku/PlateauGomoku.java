package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.Plateau;
import GomoKu.PlateauJeu2D.Position;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrien CHAUSSENDE
 */
public class PlateauGomoku extends Plateau {

    /**
     * Constructeur vide
     */
    public PlateauGomoku() {
        super();
    }

    /**
     * Constructeur de PlateauGomoku
     *
     * @param longueur : Longueur de etatPlateau
     * @param largeur : Largeur de etatPlateau
     */
    public PlateauGomoku(int longueur, int largeur) {
        super(longueur, largeur);
    }

    /**
     * Vérification de la présence de n coups alignés sur la même colonne où le
     * coup a été posé par le joueur d'identifiant id. True si c'est le cas.
     * False sinon.
     *
     * @param pos Position où a été joué le coup
     * @param id Identifiant du joueur pour vérifier la condition de victoire
     * pour ce joueur
     * @param n nombre de coups
     * @return True si n coups alignés sur la même colonne, False sinon.
     * @throws ExceptionPlateauJeu2D
     */
    @Override
    public boolean checkColonneId(Position pos, int id, int n){
        int m = 0;
        int y = pos.getY();
        int indiceStop = this.getLargeur() + 1 - n;
        for (int i = 0; ((i < this.getLargeur()) && (i < indiceStop || m != 0)); i++) {
            try {
                if (id == getIdPosition(new Position(i, y))) {
                    m++;
                    if (m >= n) {
                        return true;
                    }
                } else {
                    m = 0;
                }
            } catch (ExceptionPlateauJeu2D ex) {
                System.out.println("checkColonneId() --> Index en dehors des limites de la grille");
            }
        }
        return false;
    }

    /**
     * Vérification de la présence de n coups alignés sur la même ligne où le
     * coup a été posé par le joueur d'identifiant id. True si c'est le cas.
     * False sinon.
     *
     * @param pos Position où a été joué le coup
     * @param id ID du joueur pour vérifier la condition de victoire pour ce
     * joueur
     * @param n nombre de coups
     * @return True si n coups alignés sur la même ligne, False sinon.
     * @throws ExceptionPlateauJeu2D
     */
    @Override
    public boolean checkLigneId(Position pos, int id, int n){
        int m = 0;
        int x = pos.getX();
        int indiceStop = this.getLongueur() + 1 - n;
        for (int i = 0; ((i < this.getLongueur()) && (i < indiceStop || m != 0)); i++) {
            try {
                if (id == getIdPosition(new Position(x, i))) {
                    m++;
                    if (m >= n) {
                        return true;
                    }
                } else {
                    m = 0;
                }
            } catch (ExceptionPlateauJeu2D ex) {
                System.out.println("checkLigneId() --> Index en dehors des limites de la grille");
            }
        }
        return false;
    }
}
