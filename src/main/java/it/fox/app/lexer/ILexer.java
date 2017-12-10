package it.fox.app.lexer;


import it.fox.app.io.reader.ReaderException;

public interface ILexer {

    boolean hasNextToken() throws ReaderException;

    IToken readToken();
}
