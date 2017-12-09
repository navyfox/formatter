package it.sevenbits.app.lexer;


import it.sevenbits.app.formatter.exception.FormatterException;

public interface ILexer {

    boolean hasMoreChars()throws FormatterException;

    IToken readToken() throws FormatterException;
}
