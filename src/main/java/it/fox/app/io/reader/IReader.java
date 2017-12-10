package it.fox.app.io.reader;

public interface IReader {

    boolean hasNextChar() throws ReaderException;

    char readChar() throws ReaderException;
}
