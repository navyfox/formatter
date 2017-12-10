package it.fox.app.io.writer.implementation;

import it.fox.app.io.writer.IWriter;
import it.fox.app.io.writer.WriterException;

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

    @Override
    public void writeString(final String s) throws WriterException {

        try {
            resultString.append(s);
        } catch (Exception e) {
            throw new WriterException("Writing error", e);
        }

    }
}
