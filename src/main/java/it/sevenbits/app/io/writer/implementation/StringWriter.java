package it.sevenbits.app.io.writer.implementation;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

public class StringWriter implements IWriter {

    private StringBuilder resultString;

    public StringWriter() {
        resultString = new StringBuilder();
    }

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
}
