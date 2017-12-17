package it.fox.app.lexer;

import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.reader.implementation.StringReader;
import it.fox.app.io.reader.IReader;
import it.fox.app.lexer.*;
import it.fox.app.lexer.implementation.Lexer;
import it.fox.app.lexerCommand.ICommandLexer;
import it.fox.app.yaml.*;
import it.fox.app.stateMachineComponents.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

public class LexerTest {

    @Test
    public void testSimpleTokenize() {
        IReader reader = new StringReader(
                "a;\n" +
                        "   b");

        ILexer lexer = new Lexer(reader);

        try {
            assertTrue(lexer.hasNextToken());
            IToken token = lexer.readToken();
            assertEquals("char", token.getName());
            assertEquals("a", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("semicolon", token.getName());
            assertEquals(";", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("newline", token.getName());
            assertEquals("\n", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("space", token.getName());
            assertEquals("   ", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("char", token.getName());
            assertEquals("b", token.getLexeme());

            assertFalse(lexer.hasNextToken());
        } catch (ReaderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTwoTokenize() {
        IReader reader = new StringReader(
                "{a\n" +
                        "    b");

        ILexer lexer = new Lexer(reader);

        try {
            assertTrue(lexer.hasNextToken());
            IToken token = lexer.readToken();
            assertEquals("openbracket", token.getName());
            assertEquals("{", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("char", token.getName());
            assertEquals("a", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("newline", token.getName());
            assertEquals("\n", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("space", token.getName());
            assertEquals("    ", token.getLexeme());

            assertTrue(lexer.hasNextToken());
            token = lexer.readToken();
            assertEquals("char", token.getName());
            assertEquals("b", token.getLexeme());

            assertFalse(lexer.hasNextToken());
        } catch (ReaderException e) {
            e.printStackTrace();
        }
    }
}