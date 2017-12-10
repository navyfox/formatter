package it.fox.app.lexer;

public interface IContextLexer {
    void appendLexeme(char c);

    void setTokenName(String name);

    void appendPostpone(char c);
}
