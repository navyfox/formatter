package it.sevenbits.app.lexer;


import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.io.reader.IReader;

public interface ILexer {

    public boolean hasMoreChars()throws FormatterException;

    public IToken readToken() throws FormatterException;
}
