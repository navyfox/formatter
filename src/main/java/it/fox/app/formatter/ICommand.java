package it.fox.app.formatter;

import it.fox.app.io.writer.IWriter;
import it.fox.app.lexer.IToken;
import it.fox.app.formatter.exception.CommandException;

public interface ICommand {

    void execute(IToken token, IWriter writer) throws CommandException;
}
