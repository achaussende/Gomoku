
package GomoKu;

import GomoKu.JeuDeGomoku.JeuDeGomoku;
import GomoKu.JeuDeGomoku.JeuDeGomokuFactory;
import GomoKu.JeuDeGomoku.PlateauGomoku;
import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.Position;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class GomokuTest {
    
    public static void main(String[] args) {
        PlateauGomoku plateau= new PlateauGomoku(8,8);
        System.out.println(plateau.toString(true));
        ArrayList<Coup> l_coups=new ArrayList<Coup>(2);
        
        
        Coup c1=new Coup(1,new Position(8,9));
        l_coups.add(c1);
        c1=new Coup(2,new Position(1,1));
        l_coups.add(c1);
        
       JeuDeGomokuFactory fact=new JeuDeGomokuFactory();
       JeuDeGomoku jeu=(JeuDeGomoku) fact.CreerPartieHumainVSAleatoire(l_coups);
       System.out.println(jeu.getPlateau().toString(false));
       jeu.jouerPartie();
       
    }
    
}
