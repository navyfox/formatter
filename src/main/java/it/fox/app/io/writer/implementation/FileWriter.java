package it.fox.app.io.writer.implementation;

import it.fox.app.io.closable.ClosableException;
import it.fox.app.io.closable.IClosable;
import it.fox.app.io.writer.IWriter;
import it.fox.app.io.writer.WriterException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Class for writing characters and strings to a file.
 * Implements IWriter, IClosable.
 */

public class FileWriter implements IWriter, IClosable {

    private BufferedWriter bufferedWriter;

    /**
     * Opening the output stream
     *
     * @param path file directory path
     * @throws WriterException if an error occurred in FileReader
     */
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
    public void write(final String s) throws WriterException {
        try {
            bufferedWriter.write(s);
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
