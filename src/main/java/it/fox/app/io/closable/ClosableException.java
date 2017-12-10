package it.fox.app.io.closable;

public class ClosableException extends Exception {

    public ClosableException(final Throwable cause) {
        super(cause);
    }

    public ClosableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

