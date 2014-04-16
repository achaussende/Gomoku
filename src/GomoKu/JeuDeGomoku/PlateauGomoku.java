package GomoKu.JeuDeGomoku;

import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;
import GomoKu.PlateauJeu2D.Position;
import GomoKu.PlateauJeu2D.Plateau;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author p1105501
 */
public class PlateauGomoku extends Plateau {

    public PlateauGomoku() {
        super();
    }

    public PlateauGomoku(int longueur, int largeur) {
        super(longueur, largeur);
    }

    public boolean checkColonneId(Position pos, int id, int n) throws ExceptionPlateauJeu2D {
        int m = 0;
        int y = pos.getY();
        for (int i = 0; i < this.getLargeur(); i++) {
            if (id == getIdPosition(new Position(i, y))) {
                m++;
                if (m >= n) {
                    return true;
                }
            } else {
                m = 0;
            }
        }
        return false;
    }

    public boolean checkLigneId(Position pos, int id, int n) throws ExceptionPlateauJeu2D {
        int m = 0;
        int x = pos.getX();
        for (int i = 0; i < this.getLongueur(); i++) {
            if (id == getIdPosition(new Position(x, i))) {
                m++;
                if (m >= n) {
                    return true;
                }
            } else {
                m = 0;
            }
        }
        return false;
    }
}
