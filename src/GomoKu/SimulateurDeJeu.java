package GomoKu;

import GomoKu.ExceptionGomoku;

/**
 *
 * @author Adrien CHAUSSENDE p1105501
 */
public class SimulateurDeJeu {

    public static void main(String[] args) throws ExceptionGomoku {
        PlateauGomoku p = new PlateauGomoku(8, 8);
        System.out.println(p.toString(false));
        if(p.checkColonneId(new Position(0,2),0,3)){
        System.out.println("\nLOL\n");}
    }
}
