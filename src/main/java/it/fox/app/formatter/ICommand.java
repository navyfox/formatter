package it.fox.app.formatter;

import it.fox.app.io.writer.WriterException;
import it.fox.app.lexer.IToken;

/**
 * Interface for executing commands
 */

public interface ICommand {

    /**
     * @param token   the token that we read
     * @param context formatter context
     * @throws WriterException if an error occurred
     */
    void execute(IToken token, IContext context) throws WriterException;
}
