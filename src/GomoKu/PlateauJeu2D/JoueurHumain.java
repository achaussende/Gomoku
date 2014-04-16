
package GomoKu.PlateauJeu2D;

import java.util.Scanner;

/**
 * un Joueur Humain
 * @author Antoine CARON
 */
public class JoueurHumain extends Joueur{
    /**
     * Constructeur d'un JoueurHumain
     * @param id 
     */
    public JoueurHumain(int id) {
        super(id);
    }
    /**
     * Re-définition de la fonction qui génère le coup du Joueur
     * @param etatJeu Plateau du Jeu Actuel
     * @return Coup joué
     */
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
