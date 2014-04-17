package GomoKu.PlateauJeu2D;

/**
 * Utilitaire de fonctions
 *
 * @author Adrien CHAUSSENDE
 */
public class Utilitaire {

    /**
     * Fonction static renvoyant un entier aléatoire entre min et max (compris)
     *
     * @param min Borne inférieure/Minimum
     * @param max Borne supérieur/Maximum
     * @return int Entier compris entre le minimum et le maximum inclus
     */
    public static int monRandom(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
