
package GomoKu.PlateauJeu2D;

/**
 *
 * @author Adrien CHAUSSENDE
 */

public class Utilitaire {
    
    public static int monRandom(int min, int max) {
       return min + (int)(Math.random() * ((max - min) + 1));   
    }
    
}
