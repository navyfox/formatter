package it.fox.app.lexer;

import it.fox.app.lexer.implementation.StateLexer;

public interface IStateTransitionsLexer {
    StateLexer getNextState(StateLexer state, char c);
}
