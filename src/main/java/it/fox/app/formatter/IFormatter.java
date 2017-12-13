package it.fox.app.formatter;

import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.writer.IWriter;
import it.fox.app.lexer.ILexer;

/**
 * The formatter code
 */
public interface IFormatter {

    /**
     * @param lexer accepts lexical analysis
     * @param out   outputs the formatted code
     * @throws FormatterException if an error occurred
     * @throws ReaderException    if an error occurred
     */
    void format(ILexer lexer, IWriter out) throws FormatterException, ReaderException;
}
