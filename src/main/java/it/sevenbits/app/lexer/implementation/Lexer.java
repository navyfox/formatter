package it.sevenbits.app.lexer.implementation;


import it.sevenbits.app.formatter.exception.FormatterException;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.IToken;

public class Lexer implements ILexer {

    private final IReader reader;

    public Lexer(final IReader in) {
        reader = in; }

    @Override
    public boolean hasMoreChars() throws FormatterException {
        try {
            return reader.readNext();
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        }
    }


    @Override
    public IToken readToken() throws FormatterException {
        try {
            char c = reader.getChar();
            IToken token = new Token(c);
            return token;
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        }
    }
}