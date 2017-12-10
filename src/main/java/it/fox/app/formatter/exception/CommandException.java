package it.fox.app.formatter.exception;

public class CommandException extends Exception {

    public CommandException(final Throwable cause) {
        super(cause);
    }

    public CommandException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
