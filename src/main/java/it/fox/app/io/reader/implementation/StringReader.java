package it.fox.app.io.reader.implementation;

import it.fox.app.io.reader.IReader;
import it.fox.app.io.reader.ReaderException;

public class StringReader implements IReader {

    private String value;
    private int index;

    public StringReader(final String value) {

        this.value = value;
    }

    @Override
    public boolean hasNextChar() throws ReaderException {
        return index < value.length();
    }

    @Override
    public char readChar() throws ReaderException {

        try {
            return value.charAt(index++);
        } catch (StringIndexOutOfBoundsException e) {
            throw new ReaderException("Attempting to read outside of the string", e);
        }
    }
}
