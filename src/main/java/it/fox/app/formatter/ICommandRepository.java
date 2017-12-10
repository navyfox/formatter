package it.fox.app.formatter;

import it.fox.app.lexer.IToken;

public interface ICommandRepository {

    ICommand getCommand(IState state, IToken token);
}
