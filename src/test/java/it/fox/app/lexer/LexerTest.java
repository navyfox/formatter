package it.fox.app.lexer;

import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.reader.implementation.StringReader;
import it.fox.app.io.reader.IReader;
import it.fox.app.lexer.implementation.Lexer;
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
    public void testStateMachineLoop() {
        try {
            IReader reader = mock(IReader.class);
            when(reader.hasNextChar()).thenReturn(true, false);
            when(reader.readChar()).thenReturn('a');

            ICommandLexer command = mock(ICommandLexer.class);
            ICommandRepositoryLexer commands = mock(ICommandRepositoryLexer.class);
            when(commands.getCommand(any(State.class), anyChar())).thenReturn(command);

            IStateTransitionsLexer transitions = mock(IStateTransitionsLexer.class);

            ILexer lexer = new Lexer(reader, commands, transitions);
            lexer.readToken();


            verify(reader, times(2)).hasNextChar();
            verify(reader).readChar();
            verify(commands).getCommand(new State("default"), 'a');
            verify(command).execute(eq('a'), any(IContextLexer.class));
            verify(transitions).getNextState(new State("default"), 'a');
        } catch (ReaderException e) {

        }
    }
}