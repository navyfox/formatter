package it.fox.app.io.reader;

public class ReaderException extends Exception {

    public ReaderException(final Throwable cause) {
        super(cause);
    }

    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
