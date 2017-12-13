package it.fox.app.io.reader;

/**
 * Interface for reading by character
 */

public interface IReader {
    /**
     * Сheck if the next character can be read
     *
     * @return boolean yes|no
     * @throws ReaderException if an error occurred
     */
    boolean hasNextChar() throws ReaderException;

    /**
     * Reads the next character
     *
     * @return char next character
     * @throws ReaderException if an error occurred
     */
    char readChar() throws ReaderException;
}
