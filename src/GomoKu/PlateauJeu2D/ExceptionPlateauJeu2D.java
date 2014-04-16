package GomoKu.PlateauJeu2D;

/**
 * Type d'exception d'un jeu de Plateau 2D
 * @author Adrien CHAUSSENDE p1105501
 */
public class ExceptionPlateauJeu2D extends Exception {
    /**
     * Message de l'erreur
     */
    private String mess_err;

    /**
     * Getter du message d'erreur
     * @return mess_err
     */
    public String getMess_err() {
        return mess_err;
    }
    /**
     * Constructeur de l'exception
     * @param mess_err Message d'erreur de l'exception
     */
    public ExceptionPlateauJeu2D(String mess_err) {
        this.mess_err = mess_err;
    }
}
