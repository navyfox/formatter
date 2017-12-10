package it.fox.app.formatter;

import it.fox.app.io.writer.IWriter;
import it.fox.app.formatter.exception.FormatterException;
import it.fox.app.lexer.ILexer;

public interface IFormatter {

    void format(ILexer lexer, IWriter out) throws FormatterException;
}
