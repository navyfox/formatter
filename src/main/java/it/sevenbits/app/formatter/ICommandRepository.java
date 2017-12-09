package it.sevenbits.app.formatter;

import it.sevenbits.app.lexer.IToken;

public interface ICommandRepository {

    ICommand getCommand(IState state, IToken token);
}
