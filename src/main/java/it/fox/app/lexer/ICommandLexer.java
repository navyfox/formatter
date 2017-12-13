package it.fox.app.lexer;

/**
 * The interface of the commands that we perform for the lexer
 */
public interface ICommandLexer {
    /**
     * @param c       character that we read
     * @param context context of the lexer
     */
    void execute(char c, IContextLexer context);
}
