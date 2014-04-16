
package GomoKu.PlateauJeu2D;

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
        System.out.println("Joueur "+this.getId()+" à vous de jouer x puis y :");
        Scanner scan= new Scanner(System.in);
        Position p=new Position();
        System.out.println("X:");
        p.setX(Integer.parseInt(scan.nextLine()));
        System.out.println("Y:");
        p.setY(Integer.parseInt(scan.nextLine()));
        return new Coup(this.getId(),p);
    }
    
}
