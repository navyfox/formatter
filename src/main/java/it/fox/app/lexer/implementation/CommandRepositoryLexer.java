package it.fox.app.lexer.implementation;

import com.sun.tools.javac.util.Pair;
import it.fox.app.lexer.ICommandLexer;
import it.fox.app.lexer.ICommandRepositoryLexer;
import it.fox.app.stateMachineComponents.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The map is a repository of commands that are generated based on the current state and the char that was read
 */
public class CommandRepositoryLexer implements ICommandRepositoryLexer {

    private final Map<Pair<State, Character>, ICommandLexer> commands = new HashMap<>();

    /**
     * The command map for lexer
     */
    CommandRepositoryLexer() {

        commands.put(new Pair<>(new State("default"), null), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("char");
        });
        commands.put(new Pair<>(new State("default"), ';'), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("semicolon");
        });
        commands.put(new Pair<>(new State("default"), '\n'), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("newline");
        });
        commands.put(new Pair<>(new State("default"), ' '), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("space");
        });
        commands.put(new Pair<>(new State("spacing"), ' '), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("space");
        });
        commands.put(new Pair<>(new State("spacing"), null), (c, context) -> {
            context.appendPostpone(c);
        });
        commands.put(new Pair<>(new State("default"), '{'), (c, context) -> {
                    context.appendLexeme(c);
                    context.setTokenName("openbracket");
        });
        commands.put(new Pair<>(new State("default"), '}'), (c, context) -> {
                    context.appendLexeme(c);
                    context.setTokenName("closebracket");
        });

    }

    @Override
    public ICommandLexer getCommand(final State state, final char c) {
        ICommandLexer command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }
}
