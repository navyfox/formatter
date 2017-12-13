package it.fox.app.io.writer.implementation;

import it.fox.app.io.writer.IWriter;
import it.fox.app.io.writer.WriterException;

/**
 * Class for working with String.
 * Implements IWriter.
 */
public class StringWriter implements IWriter {

    private StringBuilder resultString;

    /**
     * Constructor
     */
    public StringWriter() {
        resultString = new StringBuilder();
    }

    /**
     * @return full output string.
     */
    public final String toString() {
        return resultString.toString();
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            resultString.append(symbol);
        } catch (Exception e) {
            throw new WriterException("Writing error", e);
        }
    }

    @Override
    public void write(final String s) throws WriterException {
        try {
            resultString.append(s);
        } catch (Exception e) {
            throw new WriterException("Writing error", e);
        }
    }
}
