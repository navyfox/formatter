package it.fox.app.formatter.exception;

public class FormatterException extends Exception {

    public FormatterException(final Throwable cause) {
        super(cause);
    }

    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
