//package it.sevenbits.app.formatter.implementation;
//
//import FormatterException;
//import IFormatter;
//import IWriter;
//import WriterException;
//import ILexer;
//import IToken;
//import Token;
//
//public class Formatter implements IFormatter {
//
//    private static final int INDENT = 4;
//    private static final char INDENT_CHAR = ' ';
//
//    @Override
//    public void format(final ILexer lexer , final IWriter out) throws FormatterException {
//        try {
//            final char nextLine = '\n';
//            final String newline = "{};";
//            char c = 0;
//            IToken previousToken = new Token(c);
//            int level = 0;
//            while (lexer.hasNextToken()) {
//                IToken currentToken = lexer.readToken();
//                if (currentToken.getName() == "open_bkt") {
//                    level++;
//                }
//                if (currentToken.getName() == "close_bkt") {
//                    level--;
//                }
//
//                if (newline.indexOf(previousToken.getLexeme()) != -1) {
//                    for (int i = 0 ; i < level * INDENT; i++) {
//                        out.write(INDENT_CHAR);
//                    }
//                }
//
//                previousToken = currentToken;
//                if (previousToken.getName() == "skip") {
//                    continue;
//                }
//                out.write(currentToken.getLexeme());
//                if (newline.indexOf(currentToken.getLexeme()) != -1) {
//                    out.write(nextLine);
//                }
//            }
//        } catch (WriterException e) {
//            throw new FormatterException("Writing error", e);
//        }
//    }
//}
