package it.fox.app.formatter;

import it.fox.app.io.reader.implementation.StringReader;
import it.fox.app.io.writer.IWriter;
import it.fox.app.io.reader.IReader;
import it.fox.app.io.writer.implementation.StringWriter;
import it.fox.app.lexer.ILexer;
import it.fox.app.lexer.implementation.Lexer;
import org.junit.Test;

public class FormatterTest {

    @Test
    public void testSimpleFormat() {
        IReader reader = new StringReader(
                "a;\n" +
                      "   b");
        IWriter writer = new StringWriter();

        ILexer lexer = new Lexer(reader);

    }
}
