package it.sevenbits.app.formatter;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.writer.IWriter;

public interface IFormatter {

    void format(IReader in, IWriter out) throws FormatterException;
}
