package it.sevenbits.app.lexer.implementation;


import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.IToken;

public class Lexer implements ILexer {

    @Override
    public boolean hasMoreTokens() {
        return false;
    }

    @Override
    public IToken readToken() {
        return null;
    }
}
