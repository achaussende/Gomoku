
package GomoKu;

/**
 *
 * @author Adrien
 */
public class JoueurAleatoire extends Joueur {

    public JoueurAleatoire(int id) {
        super(id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Position pos = new Position(Utilitaire.monRandom(0, etatJeu.getLongueur()-1),Utilitaire.monRandom(0, etatJeu.getLargeur()-1));
        System.out.println("Le joueur aléatoire joue dans la case : [" + pos.getX() + "," + pos.getY() + "]");
        return new Coup(this.getId(),pos);
    }
    
}
