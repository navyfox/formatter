package it.fox.app.io.writer;

public interface IWriter {

    void write(char symbol) throws WriterException;

    void writeString(String s) throws WriterException;
}
