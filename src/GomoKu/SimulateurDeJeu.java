package GomoKu;

import GomoKu.JeuDeGomoku.PlateauGomoku;
import GomoKu.PlateauJeu2D.Position;
import GomoKu.PlateauJeu2D.JoueurAleatoire;
import GomoKu.PlateauJeu2D.ExceptionPlateauJeu2D;

/**
 *
 * @author Adrien CHAUSSENDE p1105501
 */
public class SimulateurDeJeu {

    public static void main(String[] args) throws ExceptionPlateauJeu2D {
        PlateauGomoku p = new PlateauGomoku(8, 8);
        System.out.println(p.toString(false));
        if(p.checkColonneId(new Position(0,2),0,3)){
        System.out.println("\nLOL\n");}
        
        JoueurAleatoire ja = new JoueurAleatoire(1);
        ja.genererCoup(p);
    }
}
