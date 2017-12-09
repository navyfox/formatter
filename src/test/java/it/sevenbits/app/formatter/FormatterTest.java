package it.sevenbits.app.formatter;

import it.sevenbits.app.formatter.exception.FormatterException;
import it.sevenbits.app.formatter.implementation.Formatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.implementation.Lexer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void simpleTest() throws WriterException, ReaderException, FormatterException {
        String inputString = "Hello world";
        String expectedResult = "Helloworld";
        IReader in = new StringReader(inputString);
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals(expectedResult, out.toString());
    }

    @Test
    public void secondSimpleTest() throws WriterException, ReaderException, FormatterException {
        String inputString = "{a;}";
        String expectedResult = "{\n    a;\n}\n";
        IReader in = new StringReader(inputString);
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals(expectedResult, out.toString());
    }

    @Test
    public void thirdSimpleTest() throws WriterException, ReaderException, FormatterException {
        String inputString = "{\n    test();\n    {\n    }\n}\n";
        String expectedResult = "{\n    test();\n    {\n        }\n    }\n";
        IReader in = new StringReader(inputString);
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals(expectedResult, out.toString());
    }
}
