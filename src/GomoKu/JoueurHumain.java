
package GomoKu;

import java.util.Scanner;

/**
 *
 * @author Antoine CARON
 */
public class JoueurHumain extends Joueur{

    public JoueurHumain(int id) {
        super(id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        System.out.println("Joueur "+this.getId()+" à vous de jouer (x y;) :");
        Scanner scan= new Scanner(System.in).useDelimiter(";");
        Position p=new Position();
        p.setX(scan.nextInt());
        p.setY(scan.nextInt());
        return new Coup(this.getId(),p);
    }
    
}
