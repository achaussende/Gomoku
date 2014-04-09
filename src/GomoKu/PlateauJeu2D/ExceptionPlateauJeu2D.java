package GomoKu.PlateauJeu2D;

/**
 *
 * @author Adrien CHAUSSENDE p1105501
 */
public class ExceptionPlateauJeu2D extends Exception {
    private String mess_err;

    public String getMess_err() {
        return mess_err;
    }

    public ExceptionPlateauJeu2D(String mess_err) {
        this.mess_err = mess_err;
    }
}
