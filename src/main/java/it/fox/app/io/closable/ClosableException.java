package it.fox.app.io.closable;

/**
 * Class wrapper for Exception
 */

public class ClosableException extends Exception {

    /**
     * basic constructor
     *
     * @param message exception text
     */
    public ClosableException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public ClosableException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause   exception object
     */
    public ClosableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

