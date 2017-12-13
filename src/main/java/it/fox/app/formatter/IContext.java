package it.fox.app.formatter;

import it.fox.app.io.writer.WriterException;

/**
 * The context for formatter
 */
public interface IContext {

    /**
     * @serialField INDENT style indent for java
     */
    int INDENT = 4;
    /**
     * @serialField NEXT_LINE symbol next line
     */
    char NEXT_LINE = '\n';
    /**
     * @serialField INDENT_CHAR symbol indent
     */
    char INDENT_CHAR = ' ';

    /**
     * write new line
     *
     * @throws WriterException if an error occurred
     */
    void writeNewLine() throws WriterException;

    /**
     * @param lexeme token record
     * @throws WriterException if an error occurred
     */
    void writeLexeme(String lexeme) throws WriterException;

    /**
     * record indent
     *
     * @throws WriterException if an error occurred
     */
    void writeIndent() throws WriterException;

    /**
     * widening of gaps
     */
    void incrementIndent();

    /**
     * reduction of gaps
     */
    void decrementIndent();
}
