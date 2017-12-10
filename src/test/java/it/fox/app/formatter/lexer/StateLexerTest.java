package it.fox.app.formatter.lexer;


import it.fox.app.lexer.implementation.StateLexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

public class StateLexerTest {

    @Test
    public void testEqualStates() {
        StateLexer stateLexer1 = new StateLexer("A");
        StateLexer stateLexer2 = new StateLexer("A");

        assertNotSame(stateLexer1, stateLexer2);
        assertEquals(stateLexer1, stateLexer2);
        assertEquals(stateLexer1.hashCode(), stateLexer2.hashCode());
    }

    @Test
    public void testNotEqualStates() {
        StateLexer stateLexer1 = new StateLexer("A");
        StateLexer stateLexer2 = new StateLexer("B");

        assertNotSame(stateLexer1, stateLexer2);
        assertNotEquals(stateLexer1, stateLexer2);
        assertNotEquals(stateLexer1.hashCode(), stateLexer2.hashCode());
    }
}
