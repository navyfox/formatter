package it.fox.app.formatter.implementation;

import it.fox.app.formatter.ICommand;
import it.fox.app.formatter.ICommandRepository;
import it.fox.app.formatter.IContext;
import it.fox.app.formatter.IFormatter;
import it.fox.app.formatter.IStateTransitions;
import it.fox.app.formatter.FormatterException;
import it.fox.app.io.reader.ReaderException;
import it.fox.app.io.writer.IWriter;
import it.fox.app.io.writer.WriterException;
import it.fox.app.lexer.ILexer;
import it.fox.app.lexer.IToken;
import it.fox.app.stateMachineComponents.State;

/**
 * Class with a single method for formatting text
 */
public class Formatter implements IFormatter {

    private ICommandRepository commands = new CommandRepository();
    private IStateTransitions transitions = new StateTransitions();

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        try {
            IContext context = new Context(writer);
            State state = new State("default");
            while (lexer.hasNextToken() && state != null) {
                IToken token = lexer.readToken();
                ICommand command = commands.getCommand(state, token);
                command.execute(token, context);
                state = transitions.getNextSate(state, token);
            }
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        }
    }
}
