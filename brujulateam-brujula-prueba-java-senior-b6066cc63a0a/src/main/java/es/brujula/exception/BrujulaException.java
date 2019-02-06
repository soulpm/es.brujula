package es.brujula.exception;

/**
 * Created by jramirez on 02/09/2016.
 */
public class BrujulaException extends Exception {

    private final String message;

    public BrujulaException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
