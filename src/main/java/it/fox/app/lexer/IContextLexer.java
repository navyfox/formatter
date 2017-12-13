package it.fox.app.lexer;

/**
 * The context for lexer
 */
public interface IContextLexer {
    /**
     * Add character to lexeme
     *
     * @param c character
     */
    void appendLexeme(char c);

    /**
     * Assigns the name of the token
     *
     * @param name name of the token
     */
    void setTokenName(String name);

    /**
     * Adds a character to the buffer
     *
     * @param c character
     */
    void appendPostpone(char c);
}
