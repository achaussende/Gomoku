package GomoKu.PlateauJeu2D;

import java.util.Scanner;

/**
 * Objet de Joueur Humain
 *
 * @author Antoine CARON
 */
public class JoueurHumain extends Joueur {

    /**
     * Constructeur d'un JoueurHumain
     *
     * @param id
     */
    public JoueurHumain(int id) {
        super(id);
    }

    /**
     * Permet de générer que le coup du Joueur Humain désire jouer en lui
     * demandant de rentrer les indices de ligne et colonne où jouer son coup
     *
     * @param etatJeu Plateau du Jeu Actuel
     * @return Coup joué
     */
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        System.out.println("Joueur " + this.getId() + " à vous de jouer :");
        Scanner scan = new Scanner(System.in);
        Position p = new Position();
        System.out.println("Ligne:");
        p.setX(Integer.parseInt(scan.nextLine()));
        System.out.println("Colonne:");
        p.setY(Integer.parseInt(scan.nextLine()));
        return new Coup(this.getId(), p);
    }

}
