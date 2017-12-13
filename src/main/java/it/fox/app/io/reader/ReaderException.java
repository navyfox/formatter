package it.fox.app.io.reader;

/**
 * Class wrapper for Exception
 */

public class ReaderException extends Exception {

    /**
     * basic constructor
     *
     * @param message exception text
     */
    public ReaderException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public ReaderException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause   exception object
     */
    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
