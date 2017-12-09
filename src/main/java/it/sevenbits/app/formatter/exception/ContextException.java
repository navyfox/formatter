package it.sevenbits.app.formatter.exception;

public class ContextException extends Exception {

    public ContextException(final Throwable cause) {
        super(cause);
    }

    public ContextException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
