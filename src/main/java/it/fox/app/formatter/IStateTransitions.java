package it.fox.app.formatter;

import it.fox.app.lexer.IToken;
import it.fox.app.stateMachineComponents.State;

/**
 * Interface for generating the next state based on the current state and the token that was read
 */
public interface IStateTransitions {
    /**
     * @param state current state
     * @param token the token that we read
     * @return next state
     */
    State getNextSate(State state, IToken token);
}
