package it.fox.app.formatter;

import it.fox.app.io.writer.IWriter;
import it.fox.app.io.writer.WriterException;
import it.fox.app.io.writer.implementation.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringWriterTest {

    @Test
    public void testSimpleWrite() {
        IWriter writer = new StringWriter();
        try {
            writer.write("abc");
        } catch (WriterException e) {
        }
        assertEquals("abc", writer.toString());
    }
}
