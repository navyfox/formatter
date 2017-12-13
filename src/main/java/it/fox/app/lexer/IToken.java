package it.fox.app.lexer;

/**
 * Interface token that stores the name of the token and the lexeme
 */
public interface IToken {

    /**
     * Return the name of the token
     *
     * @return String name
     */
    String getName();

    /**
     * Return the lexeme of the token
     *
     * @return String lexeme
     */
    String getLexeme();
}
