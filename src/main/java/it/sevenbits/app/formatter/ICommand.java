package it.sevenbits.app.formatter;

import it.sevenbits.app.formatter.exception.CommandException;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.lexer.IToken;

public interface ICommand {

    void execute(IToken token, IWriter writer) throws CommandException;
}
