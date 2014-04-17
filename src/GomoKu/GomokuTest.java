package GomoKu;

import GomoKu.JeuDeGomoku.JeuDeGomoku;
import GomoKu.JeuDeGomoku.JeuDeGomokuFactory;
import GomoKu.JeuDeGomoku.PlateauGomoku;
import GomoKu.PlateauJeu2D.Coup;
import GomoKu.PlateauJeu2D.Joueur;
import GomoKu.PlateauJeu2D.Position;
import java.util.ArrayList;

/**
 * Classe main pour le test de projet le mercredi 16 Avril 2014
 *
 * @author Antoine CARON
 */
public class GomokuTest {

    public static void main(String[] args) {
        //Création d'un plateau de jeu classique
        PlateauGomoku plateau = new PlateauGomoku(8, 8);
        System.out.println(plateau.toString(true));

        //Liste de coups à poser au préalable
        ArrayList<Coup> l_coups = new ArrayList<Coup>(2);
        //Le coup en dehors des limites
        Coup c1 = new Coup(1, new Position(8, 9));
        l_coups.add(c1);
        //Le coup à l'intérieur des limites
        c1 = new Coup(2, new Position(1, 1));
        l_coups.add(c1);

        //On crée une nouvelle partie avec la liste de coups préalables
        JeuDeGomokuFactory fact = new JeuDeGomokuFactory();
        JeuDeGomoku jeu = (JeuDeGomoku) fact.CreerPartieHumainVSMonteCarlo(l_coups);
        //Affichage du plateau dans la console
        System.out.println(jeu.getPlateau().toString(false));
        //Lancement de la partie
        Joueur vainqueur = jeu.jouerPartie(true);
        //Affichage du joueur vainqueur
        if (vainqueur != null) {
            System.out.println("Le joueur vainqueur est : " + vainqueur.getId());
        }

    }

}
