package it.fox.app.io.reader.implementation;

import it.fox.app.io.closable.ClosableException;
import it.fox.app.io.closable.IClosable;
import it.fox.app.io.reader.IReader;
import it.fox.app.io.reader.ReaderException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Class for reading char from file.
 * Implements IReader, IClosable.
 */

public class FileReader implements IReader, IClosable {

    private BufferedReader bufferedReader;
    private int currentSymbolId;

    /**
     * Opening the input stream
     *
     * @param path file directory path
     * @throws ReaderException if an error occurred in FileReader
     */
    public FileReader(final String path) throws ReaderException {
        try {
            InputStream fileStream =
                    new FileInputStream(new File(path));
            Reader fileReader =
                    new InputStreamReader(fileStream, "utf-8");
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new ReaderException("Opening file error", e);
        } catch (UnsupportedEncodingException e) {
            throw new ReaderException("Unsupported encoding", e);
        }
    }

    @Override
    public boolean hasNextChar() throws ReaderException {
        try {
            currentSymbolId = bufferedReader.read();
            return currentSymbolId > -1;
        } catch (IOException e) {
            throw new ReaderException("Attempting to read outside of the input stream", e);
        }
    }

    @Override
    public char readChar() throws ReaderException {
        return (char) currentSymbolId;
    }

    @Override
    public void close() throws ClosableException {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new ClosableException("Closing stream error", e);
        }
    }
}
