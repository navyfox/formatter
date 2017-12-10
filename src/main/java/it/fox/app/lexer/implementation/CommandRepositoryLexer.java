package it.fox.app.lexer.implementation;

import it.fox.app.lexer.ICommandLexer;
import it.fox.app.lexer.ICommandRepositoryLexer;

import java.util.HashMap;
import java.util.Map;

public class CommandRepositoryLexer implements ICommandRepositoryLexer {

    private final Map<Pair<StateLexer, Character>, ICommandLexer> commands = new HashMap<>();

    public CommandRepositoryLexer() {

        commands.put(new Pair<>(new StateLexer("default"), null), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("char");
        });
        commands.put(new Pair<>(new StateLexer("default"), ';'), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("semicolon");
        });
        commands.put(new Pair<>(new StateLexer("default"), '\n'), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("newline");
        });
        commands.put(new Pair<>(new StateLexer("default"), ' '), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("space");
        });
        commands.put(new Pair<>(new StateLexer("spacing"), ' '), (c, context) -> {
            context.appendLexeme(c);
            context.setTokenName("space");
        });
        commands.put(new Pair<>(new StateLexer("spacing"), null), (c, context) -> {
            context.appendPostpone(c);
        });

    }

    @Override
    public ICommandLexer getCommand(StateLexer state, char c) {
        ICommandLexer command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character)null));
        }
        return command;
    }
}
