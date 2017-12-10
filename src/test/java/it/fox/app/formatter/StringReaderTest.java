package it.fox.app.formatter;

import it.fox.app.io.reader.IReader;
import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.reader.implementation.StringReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringReaderTest {

    @Test
    public void testSimpleRead() {
        IReader reader = new StringReader("abc");

        try {
            assertTrue(reader.hasNextChar());
            assertEquals('a', reader.readChar());

            assertTrue(reader.hasNextChar());
            assertEquals('b', reader.readChar());

            assertTrue(reader.hasNextChar());
            assertEquals('c', reader.readChar());
        } catch (ReaderException e) {

        }
    }
}
