package it.fox.app.lexerCommand.implementation;

import it.fox.app.lexer.IContextLexer;
import it.fox.app.lexerCommand.ICommandLexer;

/**
 *
 */
public class Endspace implements ICommandLexer {
    @Override
    public void execute(final char c, final IContextLexer context) {
        context.appendPostpone(c);
    }
}