package it.fox.app.lexer;

import it.fox.app.io.reader.ReaderException;

/**
 * The interface of lexical analysis
 */
public interface ILexer {

    /**
     * Check if the next token can be read
     *
     * @return boolean yes|no
     * @throws ReaderException if an error occurred
     */
    boolean hasNextToken() throws ReaderException;

    /**
     * Return the name of the token
     *
     * @return String name of the token
     * @throws ReaderException if an error occurred
     */
    IToken readToken() throws ReaderException;
}
