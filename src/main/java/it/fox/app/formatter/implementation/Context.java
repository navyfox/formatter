//package it.sevenbits.app.formatter.implementation;
//
//import ContextException;
//import IContext;
//import IWriter;
//import WriterException;
//import IToken;
//
//public class Context implements IContext {
//
//    private int indentLevel = 0;
//
//    @Override
//    public void incrementIndent() {
//        this.indentLevel++;
//    }
//
//    @Override
//    public void decrementIndent() {
//        this.indentLevel--;
//    }
//
//    @Override
//    public void writeLexeme(final IToken token, final IWriter writer) throws ContextException {
//        try {
//            for (char symbol : token.getLexeme().toCharArray()) {
//                writer.write(symbol);
//            }
//        } catch (WriterException e) {
//            throw new ContextException(e);
//        }
//    }
//
//    @Override
//    public void writeNewLine(final IWriter writer) throws ContextException {
//        try {
//            writer.write(NEXT_LINE);
//        } catch (WriterException e) {
//            throw new ContextException(e);
//        }
//    }
//
//    @Override
//    public void writeIndent(final IWriter writer) throws ContextException {
//        try {
//            for (int i = 0; i < INDENT * indentLevel; i++) {
//                writer.write(INDENT_CHAR);
//            }
//        } catch (WriterException e) {
//            throw new ContextException(e);
//        }
//    }
//}
