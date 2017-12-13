package it.fox.app.formatter;

import it.fox.app.lexer.IToken;
import it.fox.app.stateMachineComponents.State;

/**
 * The formatter repository command interface that implements the logic of finite state machines
 */

public interface ICommandRepository {
    /**
     * @param state current state
     * @param token the token that we read
     * @return command for formatter
     */
    ICommand getCommand(State state, IToken token);
}
