package it.fox.app.lexer;

import it.fox.app.lexer.implementation.StateLexer;

public interface ICommandRepositoryLexer {
    ICommandLexer getCommand(StateLexer state, char c);
}
