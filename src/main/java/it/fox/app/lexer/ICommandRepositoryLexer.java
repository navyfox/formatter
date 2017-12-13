package it.fox.app.lexer;

import it.fox.app.stateMachineComponents.State;

/**
 * The lexer repository command interface that implements the logic of finite state machines
 */
public interface ICommandRepositoryLexer {
    /**
     * @param state current state
     * @param c     the character that we read
     * @return command for lexer
     */
    ICommandLexer getCommand(State state, char c);
}
