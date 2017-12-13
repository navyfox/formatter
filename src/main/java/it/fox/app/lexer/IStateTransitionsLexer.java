package it.fox.app.lexer;

import it.fox.app.stateMachineComponents.State;

/**
 * Interface for generating the next state based on the current state and the character that was read
 */
public interface IStateTransitionsLexer {
    /**
     * Return the next state based on the current state and the character that was read
     *
     * @param state current state
     * @param c     character
     * @return next state
     */
    State getNextState(State state, char c);
}
