package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.IToken;

public class Formatter implements IFormatter {

    public static final int INDENT = 4;
    public static final char INDENT_CHAR = ' ';

    @Override
    public void format(final IReader in, final IWriter out) throws FormatterException {
        try {
            char currentSymbol;
            final char nextLine = '\n';
            char previousSymbol = 0;
            int level = 0;
            final String newline = "{};";
            final String skip = "\n\t ";
            while (in.readNext()) {
                currentSymbol = in.getChar();
                if (currentSymbol == '{') {
                    level++;
                }
                if (currentSymbol == '}') {
                    level--;
                }

                if (newline.indexOf(previousSymbol) != -1) {
                    for (int i = 0 ; i < level * INDENT; i++) {
                        out.write(INDENT_CHAR);
                    }
                }

                previousSymbol = currentSymbol;
                if (skip.indexOf(previousSymbol) != -1) {
                    continue;
                }
                out.write(currentSymbol);
                if (newline.indexOf(currentSymbol) != -1) {
                    out.write(nextLine);
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        }
    }

    public void formatLexer(final ILexer lexer , final IWriter out) throws FormatterException {
        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readToken();
            String lexeme = token.getLexeme();
            //do something
        }
    }
}
