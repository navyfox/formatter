package it.sevenbits.app.io.writer.implementation;

import it.sevenbits.app.io.closable.ClosableException;
import it.sevenbits.app.io.closable.IClosable;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

import java.io.*;

public class FileWriter implements IWriter, IClosable {

    private BufferedWriter bufferedWriter;

    public FileWriter(final String path) throws WriterException {
        try {
            FileOutputStream outputStream =
                    new FileOutputStream(new File(path));
            Writer fileWriter =
                    new OutputStreamWriter(outputStream, "utf-8");
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new WriterException("Opening file error", e);
        }
    }


    @Override
    public void write(final char symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Writing error", e);
        }
    }

    @Override
    public void close() throws ClosableException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new ClosableException("Closing error", e);
        }
    }
}
