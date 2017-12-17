package it.fox.app.lexerCommand.implementation;

import it.fox.app.lexer.IContextLexer;
import it.fox.app.lexerCommand.ICommandLexer;

/**
 * Created by rim on 18.12.2017.
 */
public class Spaces implements ICommandLexer {
    @Override
    public void execute(final char c, final IContextLexer context) {
        context.appendLexeme(c);
        context.setTokenName("space");
    }
}
