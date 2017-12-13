package it.fox.app.lexer.implementation;

import it.fox.app.lexer.IToken;

/**
 * Class token that stores the name of the token and the lexeme
 */
public final class Token implements IToken {
    private String name;
    private String lexeme;

    /**
     * A basic constructor initializing the fields of an instance of the class
     *
     * @param name   name of the token
     * @param lexeme lexeme
     */
    Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        return name != null ? name.equals(token.name) : token.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLexeme() {
        return this.lexeme;
    }
}
