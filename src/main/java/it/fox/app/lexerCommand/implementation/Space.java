package it.fox.app.lexerCommand.implementation;

import it.fox.app.lexer.IContextLexer;
import it.fox.app.lexerCommand.ICommandLexer;

/**
 *
 */
public class Space implements ICommandLexer {
    @Override
    public void execute(final char c, final IContextLexer context) {
        context.appendLexeme(c);
        context.setTokenName("space");
    }
}
