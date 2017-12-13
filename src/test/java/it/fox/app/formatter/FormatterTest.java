package it.fox.app.formatter;

import it.fox.app.formatter.implementation.Formatter;
import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.reader.implementation.StringReader;
import it.fox.app.io.writer.IWriter;
import it.fox.app.io.reader.IReader;
import it.fox.app.io.writer.WriterException;
import it.fox.app.io.writer.implementation.StringWriter;
import it.fox.app.lexer.ILexer;
import it.fox.app.lexer.implementation.Lexer;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class FormatterTest {

    @Test
    public void testSimpleFormat() throws FormatterException, ReaderException {
        IReader reader = new StringReader(
                "a;\n" +
                      "   b");
        IWriter writer = new StringWriter();

        ILexer lexer = new Lexer(reader);

        IFormatter formatter = new Formatter();
        formatter.format(lexer, writer);

        assertEquals("a;\n" +
                              "b",
                              writer.toString());

    }
}
