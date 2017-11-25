package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.IToken;
import it.sevenbits.app.lexer.implementation.Token;

public class Formatter implements IFormatter {

    private static final int INDENT = 4;
    private static final char INDENT_CHAR = ' ';

    @Override
    public void format(final ILexer lexer , final IWriter out) throws FormatterException {
        try {
            final char nextLine = '\n';
            final String newline = "{};";
            char c = 0;
            IToken previousToken = new Token(c);
            int level = 0;
            while (lexer.hasMoreChars()) {
                IToken currentToken = lexer.readToken();
                if (currentToken.getName() == "open_bkt") {
                    level++;
                }
                if (currentToken.getName() == "close_bkt") {
                    level--;
                }

                if (newline.indexOf(previousToken.getLexeme()) != -1) {
                    for (int i = 0 ; i < level * INDENT; i++) {
                        out.write(INDENT_CHAR);
                    }
                }

                previousToken = currentToken;
                if (previousToken.getName() == "skip") {
                    continue;
                }
                out.write(currentToken.getLexeme());
                if (newline.indexOf(currentToken.getLexeme()) != -1) {
                    out.write(nextLine);
                }
            }
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        }
    }
}
