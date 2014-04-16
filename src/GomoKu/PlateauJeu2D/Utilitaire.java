
package GomoKu.PlateauJeu2D;

/**
 * Utilitaire de fonctions pour un Plateau de Jeu 2D
 * @author Adrien CHAUSSENDE
 */
public class Utilitaire {
    /**
     * Fonction static renvoyant un entier aléatoire entre min et max (compris)
     * @param min
     * @param max
     * @return int 
     */
    public static int monRandom(int min, int max) {
       return min + (int)(Math.random() * ((max - min) + 1));   
    }
    
}
