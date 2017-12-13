package it.fox.app.formatter.implementation;

import com.sun.tools.javac.util.Pair;
import it.fox.app.formatter.ICommand;
import it.fox.app.formatter.ICommandRepository;
import it.fox.app.lexer.IToken;
import it.fox.app.stateMachineComponents.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The map is a repository of commands that are generated based on the current state and the token that was read
 */
public final class CommandRepository implements ICommandRepository {

    private final Map<Pair<State, String>, ICommand> commands = new HashMap<>();

    /**
     * The map command for formatter
     */
    CommandRepository() {
        commands.put(new Pair<>(new State("default"), "char"), ((token, context) -> context.writeLexeme(token.getLexeme())));
        commands.put(new Pair<>(new State("default"), "semicolon"), ((token, context) -> {
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
        }));
        commands.put(new Pair<>(new State("linestart"), "newline"), ((token, context) -> {
        }));
        commands.put(new Pair<>(new State("linestart"), "space"), (((token, context) -> {
        })));
        commands.put(new Pair<>(new State("linestart"), "char"), ((token, context) -> context.writeLexeme(token.getLexeme())));
    }

    @Override
    public ICommand getCommand(final State state, final IToken token) {
        ICommand command = commands.get(new Pair<>(state, token.getName()));
        if (command == null) {
            command = commands.get(new Pair<>(state, (String) null));
        }
        return command;
    }

}
