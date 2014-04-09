package GomoKu;

/**
 *
 * @author Adrien CHAUSSENDE p1105501
 */
public class ExceptionGomoku extends Exception {
    private String mess_err;

    public ExceptionGomoku(String mess_err) {
        this.mess_err = mess_err;
    }
}
