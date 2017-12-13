package it.fox.app.formatter.implementation;

import it.fox.app.formatter.IContext;
import it.fox.app.io.writer.IWriter;
import it.fox.app.io.writer.WriterException;

/**
 * Context for formatter
 */
public class Context implements IContext {

    /**
     * Out for context
     */
    private IWriter writer;

    /**
     * @param writer write context for formatter
     */
    Context(final IWriter writer) {
        this.writer = writer;
    }

    private int indentLevel = 0;

    @Override
    public void incrementIndent() {
        this.indentLevel++;
    }

    @Override
    public void decrementIndent() {
        this.indentLevel--;
    }

    @Override
    public void writeLexeme(final String lexeme) throws WriterException {
        writer.write(lexeme);
    }

    @Override
    public void writeNewLine() throws WriterException {
        writer.write(NEXT_LINE);
    }

    @Override
    public void writeIndent() throws WriterException {
        for (int i = 0; i < INDENT * indentLevel; i++) {
            writer.write(INDENT_CHAR);

        }
    }
}
