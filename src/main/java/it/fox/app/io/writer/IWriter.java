package it.fox.app.io.writer;

/**
 * Interface for writing by character or string
 */

public interface IWriter {

    /**
     * writing by character
     *
     * @param symbol char
     * @throws WriterException if an error occurred
     */
    void write(char symbol) throws WriterException;

    /**
     * writing by string
     *
     * @param s String
     * @throws WriterException if an error occurred
     */
    void write(String s) throws WriterException;
}
