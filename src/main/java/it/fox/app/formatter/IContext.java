package it.fox.app.formatter;


import it.fox.app.io.writer.IWriter;
import it.fox.app.lexer.IToken;
import it.fox.app.formatter.exception.ContextException;

public interface IContext {

    int INDENT = 4;
    char NEXT_LINE = '\n';
    char INDENT_CHAR = ' ';

    void writeLexeme(IToken token, IWriter writer) throws ContextException;

    void writeNewLine(IWriter writer) throws ContextException;

    void writeIndent(IWriter writer) throws ContextException;

    void incrementIndent();

    void decrementIndent();
}
