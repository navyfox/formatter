package it.fox.app.io.writer;

/**
 * Class wrapper for Exception
 */

public class WriterException extends Exception {

    /**
     * basic constructor
     *
     * @param message exception text
     */
    public WriterException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public WriterException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause   exception object
     */
    public WriterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}