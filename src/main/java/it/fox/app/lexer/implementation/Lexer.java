package it.fox.app.lexer.implementation;

import it.fox.app.io.reader.IReader;
import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.reader.implementation.StringReader;
import it.fox.app.lexer.ICommandLexer;
import it.fox.app.lexer.ICommandRepositoryLexer;
import it.fox.app.lexer.IContextLexer;
import it.fox.app.lexer.ILexer;
import it.fox.app.lexer.IStateTransitionsLexer;
import it.fox.app.lexer.IToken;
import it.fox.app.stateMachineComponents.State;

/**
 * The class of lexical analysis
 */
public class Lexer implements ILexer, IContextLexer {

    private final IReader reader;

    private String tokenName;
    private StringBuilder tokenLexeme;
    private ICommandRepositoryLexer commands;
    private IStateTransitionsLexer transitions;
    private StringBuilder postponeBuffer = new StringBuilder();

    /**
     * The basic constructor that calls the another constructor
     * and passes into it the argument class that implements iReader interface
     *
     * @param reader class that implements iReader interface
     */
    public Lexer(final IReader reader) {
        this(reader, new CommandRepositoryLexer(), new StateTransitionsLexer());
    }

    /**
     * The constructor initializes instance of a class
     *
     * @param reader      class that implements iReader interface
     * @param commands    class that implements ICommandRepository interface
     * @param transitions class that implements IStateTransitions interface
     */
    public Lexer(final IReader reader, final ICommandRepositoryLexer commands, final IStateTransitionsLexer transitions) {
        this.reader = reader;
        this.commands = commands;
        this.transitions = transitions;
    }

    @Override
    public boolean hasNextToken() throws ReaderException {
        return postponeBuffer.length() > 0 || this.reader.hasNextChar();
    }


    @Override
    public IToken readToken() throws ReaderException {
        tokenLexeme = new StringBuilder();
        State state = new State("default");


        IReader postponeReader = new StringReader(postponeBuffer.toString());

        while (postponeReader.hasNextChar() && state != null) {
            char c = postponeReader.readChar();
            ICommandLexer command = commands.getCommand(state, c);
            command.execute(c, this);
            state = transitions.getNextState(state, c);
        }
        postponeBuffer = new StringBuilder();

        while (reader.hasNextChar() && state != null) {
            char c = reader.readChar();
            ICommandLexer command = commands.getCommand(state, c);
            command.execute(c, this);
            state = transitions.getNextState(state, c);
        }

        return new Token(tokenName, tokenLexeme.toString());
    }

    @Override
    public void appendLexeme(final char c) {
        tokenLexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendPostpone(final char c) {
        postponeBuffer.append(c);
    }
}