package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.lexer.IToken;


public class Token implements IToken{

    private String name;
    private char lexeme;

    public Token(char ch){
        switch (ch){
            case '{':
                name = "open_bkt";
                lexeme = ch;
                break;
            case '}':
                name = "close_bkt";
                lexeme = ch;
                break;
            case ';':
                name = "semicolon";
                lexeme = ch;
                break;
            case '\t':
                name = "skip";
                lexeme = ch;
                break;
            case '\n':
                name = "skip";
                lexeme = ch;
                break;
            case ' ':
                name = "skip";
                lexeme = ch;
                break;
            default:
                name = "other";
                lexeme = ch;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public char getLexeme() {
        return this.lexeme;
    }
}
