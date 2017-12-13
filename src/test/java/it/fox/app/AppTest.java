package it.fox.app;


import it.fox.app.formatter.FormatterException;
import it.fox.app.formatter.IFormatter;
import it.fox.app.formatter.implementation.Formatter;
import it.fox.app.io.reader.IReader;
import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.reader.implementation.StringReader;
import it.fox.app.io.writer.IWriter;
import it.fox.app.io.writer.implementation.StringWriter;
import it.fox.app.lexer.ILexer;
import it.fox.app.lexer.implementation.Lexer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void simpleTest() throws FormatterException, ReaderException {
        String inputString = "Hello";
        String expectedResult = "Hello";
        IReader in = new StringReader(inputString);
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals(expectedResult, out.toString());
    }

    @Test
    public void secondSimpleTest() throws FormatterException, ReaderException {
        String inputString = "{a;}";
        String expectedResult = "{\n    a;\n}\n";
        IReader in = new StringReader(inputString);
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals(expectedResult, out.toString());
    }

    @Test
    public void thirdSimpleTest() throws FormatterException, ReaderException {
        String inputString = "{\n    test();\n    {\n    }\n}\n";
        String expectedResult = "{\n    test();\n    {\n        }\n    }\n";
        IReader in = new StringReader(inputString);
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals(expectedResult, out.toString());
    }
}
