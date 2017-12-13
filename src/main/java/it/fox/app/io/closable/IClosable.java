package it.fox.app.io.closable;

/**
 * Interface wrapper for AutoClosable
 */
public interface IClosable extends AutoCloseable {

    @Override
    void close() throws ClosableException;
}
