package it.fox.app;

import it.fox.app.formatter.IFormatter;
import it.fox.app.formatter.implementation.Formatter;
import it.fox.app.io.reader.implementation.FileReader;
import it.fox.app.io.writer.implementation.FileWriter;
import it.fox.app.lexer.ILexer;
import it.fox.app.lexer.implementation.Lexer;

/**
 * Class main.
 */
public final class App {

    /**
     * App method.
     *
     * @param args console arguments
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {

        FileReader in = new FileReader(args[0]);
        FileWriter out = new FileWriter(args[1]);

        ILexer lexer = new Lexer(in);
        IFormatter formatter = new Formatter();
        formatter.format(lexer, out);

    }
}
