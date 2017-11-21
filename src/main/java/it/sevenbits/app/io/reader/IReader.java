package it.sevenbits.app.io.reader;

public interface IReader {

    boolean readNext() throws ReaderException;

    char getChar() throws ReaderException;
}
