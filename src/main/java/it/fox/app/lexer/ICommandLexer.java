package it.fox.app.lexer;


public interface ICommandLexer {
    void execute(char c, IContextLexer context);
}
