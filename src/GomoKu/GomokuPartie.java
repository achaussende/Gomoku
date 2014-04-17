package GomoKu;

import GomoKu.JeuDeGomoku.JeuDeGomoku;
import GomoKu.JeuDeGomoku.JeuDeGomokuFactory;
import GomoKu.JeuDeGomoku.JeuDeGomokuToriqueFactory;
import GomoKu.PlateauJeu2D.Joueur;
import java.util.Scanner;

/**
 * Classe main final du Gomoku par Antoine CARON et Adrien CHAUSSENDE
 *
 * @author Adrien CHAUSSENDE
 */
public class GomokuPartie {

    public static void main(String[] args) {
        System.out.println("Bienvenue sur PolyGomoku par Antoine CARON et Adrien CHAUSSENDE.");
        System.out.println("Deux types de Gomoku sont disponible : Gomoku Classique et Gomoku avec plateau Torique.");
        Scanner scan = new Scanner(System.in);
        int choix = 0;
        while (choix != 1 && choix != 2) {
            System.out.println("Tapez 1 pour le classique ou 2 pour le torique.");
            choix = Integer.parseInt(scan.nextLine());
            if (choix == 1) {
                JeuDeGomokuFactory fact = new JeuDeGomokuFactory();
                JeuDeGomoku jeu = (JeuDeGomoku) fact.CreerPartieHumainVSMonteCarlo(null);
                System.out.println(jeu.getPlateau().toString(false));
                Joueur vainqueur = jeu.jouerPartie(true);
                if (vainqueur != null) {
                    System.out.println("Le joueur vainqueur est : " + vainqueur.getId());
                    choix = 1;
                } else {
                    System.out.println("Egalité !");
                    choix = 1;
                }
            } else if (choix == 2) {
                JeuDeGomokuToriqueFactory fact = new JeuDeGomokuToriqueFactory();
                JeuDeGomoku jeu = (JeuDeGomoku) fact.CreerPartieHumainVSMonteCarlo(null);
                System.out.println(jeu.getPlateau().toString(false));
                Joueur vainqueur = jeu.jouerPartie(true);
                if (vainqueur != null) {
                    System.out.println("Le joueur vainqueur est : " + vainqueur.getId());
                    choix = 2;
                } else {
                    System.out.println("Egalité !");
                    choix = 2;
                }
            } else {
                System.out.println("Mauvais nombre.");
            }
        }
    }
}
